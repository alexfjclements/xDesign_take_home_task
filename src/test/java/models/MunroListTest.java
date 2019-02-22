package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MunroListTest {
    Munro munro;
    Munro munro2;
    Munro munro3;
    MunroList munroList;

    @Before
    public void before() {
        munro = new Munro("Ben More", 1245, MunroType.MUNRO, "NE6678383");
        munro2 = new Munro("Ben More", 1245, MunroType.MUNRO, "NE6678383");
        munro3 = new Munro("Ben More", 1245, MunroType.MUNRO, "NE6678383");
        munroList = new MunroList();
    }

    @Test
    public void getMunroList() {
        assertEquals(0, munroList.getMunroList().size());
    }

    @Test
    public void addMunro() {
        munroList.addMunro(munro);
        munroList.addMunro(munro2);
        munroList.addMunro(munro3);
        assertEquals(3, munroList.getMunroList().size());
    }
}