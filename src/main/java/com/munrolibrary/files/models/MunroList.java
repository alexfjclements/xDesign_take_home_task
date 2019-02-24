package com.munrolibrary.files.models;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MunroList {
    private ArrayList<Munro> munroList;
    private ArrayList<Munro> filteredMunroList;

    public MunroList() {
        munroList = new ArrayList<>();
    }

    public ArrayList<Munro> getFullMunroList() {
        return new ArrayList(munroList);
    }

    public void addMunro(Munro munroToAdd) {
        this.munroList.add(munroToAdd);
    }

    public ArrayList<Munro> filterMunroList(ArrayList<Enum> filterCriteria, HashMap<String, Integer> numericalFilterCriteria) {
        filteredMunroList = new ArrayList<>(munroList);

        errorHandling(numericalFilterCriteria);

        munroTypePreference(filterCriteria);

        munroHeightLimits(numericalFilterCriteria);

        munroHeightOrder(filterCriteria);

        munroNameOrder(filterCriteria);

        listToBeTruncated(numericalFilterCriteria);

        return filteredMunroList;
    }

    private void sortHeightAscending(){
        Collections.sort(filteredMunroList);
    }

    private void sortHeightDescending(){
        sortHeightAscending();
        Collections.reverse(filteredMunroList);
    }

    private void sortAToZ(){
        Collections.sort(filteredMunroList, Comparator.comparing(Munro::getName));
    }

    private void sortZToA(){
        sortAToZ();
        Collections.reverse(filteredMunroList);
    }

    private void truncateList(int noToDisplay){
        List<Munro> filteredListUpdate = new ArrayList<>();
        filteredListUpdate = filteredMunroList.subList(0, noToDisplay);
        filteredMunroList = new ArrayList<>(filteredListUpdate);
    }

    private void minHeightFilter(int minHeight){
        sortHeightDescending();

        for (int i = 0; i < filteredMunroList.size(); i++){
            if (filteredMunroList.get(i).getHeight() < minHeight){
                truncateList(i);
                break;
            }
        }
    }

    private void maxHeightFilter(int maxHeight){
        sortHeightAscending();

        for (int i = 0; i < filteredMunroList.size(); i++){
            if (filteredMunroList.get(i).getHeight() > maxHeight){
                truncateList(i);
                break;
            }
        }
    }

    private void errorHandling(HashMap<String, Integer> numericalQueryElements){
        if (numericalQueryElements.containsKey("maxHeight") && numericalQueryElements.containsKey("minHeight")){
            if (numericalQueryElements.get("maxHeight") < numericalQueryElements.get("minHeight")){
                System.out.println("Invalid query. Max height should be greater than min height.");
            }
        }
    }

    private void munroTypePreference(ArrayList<Enum> filterCriteria){

        if (filterCriteria.contains(FilterCriteria.MUNRO)) {
            reduceToMunro();
        } else if (filterCriteria.contains(FilterCriteria.TOP)) {
            reduceToTop();
        }

    }

    private void reduceToMunro(){
        filteredMunroList.removeIf((munro) -> (munro.getType() == MunroType.MUNROTOP));
    }

    private void reduceToTop(){
        filteredMunroList.removeIf((munro) -> (munro.getType() == MunroType.MUNRO));
    }

    private void munroHeightLimits(HashMap<String, Integer> numericalFilterCriteria){
        if (numericalFilterCriteria.containsKey("minHeight")){
            minHeightFilter(numericalFilterCriteria.get("minHeight"));
        }

        if (numericalFilterCriteria.containsKey("maxHeight")){
            maxHeightFilter(numericalFilterCriteria.get("maxHeight"));
        }
    }

    private void munroHeightOrder(ArrayList<Enum> filterCriteria){
        if (filterCriteria.contains(FilterCriteria.HEIGHTASCENDING)) {
            sortHeightAscending();
        } else if (filterCriteria.contains(FilterCriteria.HEIGHTDESCENDING)) {
            sortHeightDescending();
        }
    }

    private void munroNameOrder(ArrayList<Enum> filterCriteria){
        if (filterCriteria.contains(FilterCriteria.ATOZ)) {
            sortAToZ();
        } else if (filterCriteria.contains(FilterCriteria.ZTOA)){
            sortZToA();
        }
    }

    private void listToBeTruncated(HashMap<String, Integer> numericalFilterCriteria){
        if (numericalFilterCriteria.containsKey("NumberToDisplay")){
            truncateList(numericalFilterCriteria.get("NumberToDisplay"));
        }
    }
}
