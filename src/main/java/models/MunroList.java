package models;

import java.util.ArrayList;

public class MunroList {
    private ArrayList<Munro> munroList;

    public MunroList() {
        munroList = new ArrayList<Munro>();
    }

    public ArrayList<Munro> getMunroList() {
        return new ArrayList(munroList);
    }

    public void addMunro(Munro munroToAdd) {
        this.munroList.add(munroToAdd);
    }
}
