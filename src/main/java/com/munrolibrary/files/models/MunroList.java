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
}
