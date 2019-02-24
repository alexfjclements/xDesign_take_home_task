package com.munrolibrary.files.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

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
}
