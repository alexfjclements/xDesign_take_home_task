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

        if (filterCriteria.contains(FilterCriteria.HEIGHTASCENDING)) {
            sortHeightAscending();
        } else if (filterCriteria.contains(FilterCriteria.HEIGHTDESCENDING)) {
            sortHeightDescending();
        }

        if (filterCriteria.contains(FilterCriteria.ATOZ)) {
            sortAToZ();
        } else if (filterCriteria.contains(FilterCriteria.ZTOA)){
            sortZToA();
        }

        if (numericalFilterCriteria.containsKey("NoToDisplay")){
            truncateList(numericalFilterCriteria.get("NoToDisplay"));
        }

        if (numericalFilterCriteria.containsKey("minHeight")){
            minHeightFilter(numericalFilterCriteria.get("minHeight"));
        }

        if (numericalFilterCriteria.containsKey("maxHeight")){
            maxHeightFilter(numericalFilterCriteria.get("maxHeight"));
        }

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
}
