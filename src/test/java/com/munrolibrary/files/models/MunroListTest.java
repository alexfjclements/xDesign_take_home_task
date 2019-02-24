package com.munrolibrary.files.models;

import com.munrolibrary.files.components.DataParser;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MunroListTest {
    Munro munro;
    Munro munro2;
    Munro munro3;
    MunroList munroList;
    DataParser dataParser;

    @Before
    public void before() throws IOException {
        ArrayList<String> params = new ArrayList<String>();
        params.add("1");
        params.add("1");
        params.add("http://www.streetmap.co.uk/newmap.srf?x=277324&y=730857&z=3&sv=277324");
        params.add("730857&st=4&tl=~&bi=~&lu=N&ar=y");
        params.add("http://www.geograph.org.uk/gridref/NN7732430857");
        params.add("http://www.hill-bagging.co.uk/mountaindetails.php?qu=S&rf=1");
        params.add("Ben Chonzie");
        params.add("1");
        params.add("01A");
        params.add("1.1");
        params.add("931");
        params.add("3054");
        params.add("51 52");
        params.add("OL47W 368W 379W");
        params.add("NN773308");
        params.add("NN7732430857");
        params.add("277324");
        params.add("730857");
        params.add("MUN");
        params.add("MUN");
        params.add("MUN");
        params.add("MUN");
        params.add("MUN");
        params.add("MUN");
        params.add("MUN");
        params.add("MUN");
        params.add("MUN");
        params.add("MUN");
        params.add("MUN");

        munro = new Munro(params);
        munro2 = new Munro(params);
        munro3 = new Munro(params);
        munroList = new MunroList();

        dataParser = new DataParser();
        dataParser.dataBuilder("munrotab_v6.2");
    }

    @Test
    public void getFullMunroList() {
        assertEquals(0, munroList.getFullMunroList().size());
    }

    @Test
    public void addMunro() {
        munroList.addMunro(munro);
        munroList.addMunro(munro2);
        munroList.addMunro(munro3);
        assertEquals(3, munroList.getFullMunroList().size());
    }

    @Test
    public void canSortHeightByAscending(){
        ArrayList<Enum> filterParams = new ArrayList<>();
        filterParams.add(FilterCriteria.HEIGHTASCENDING);

        HashMap<String, Integer> filterNumbers = new HashMap<>();

        ArrayList<Munro> sortedList = dataParser.getParsedMunroList().filterMunroList(filterParams, filterNumbers);
        assertEquals("Beinn Teallach", sortedList.get(0).getName());
    }

    @Test
    public void canSortHeightByDescending(){
        ArrayList<Enum> filterParams = new ArrayList<>();
        filterParams.add(FilterCriteria.HEIGHTDESCENDING);

        HashMap<String, Integer> filterNumbers = new HashMap<>();

        ArrayList<Munro> sortedList = dataParser.getParsedMunroList().filterMunroList(filterParams, filterNumbers);
        assertEquals("Ben Nevis", sortedList.get(0).getName());
    }

    @Test
    public void canSortNameAToZ(){
        ArrayList<Enum> filterParams = new ArrayList<>();
        filterParams.add(FilterCriteria.ATOZ);

        HashMap<String, Integer> filterNumbers = new HashMap<>();

        ArrayList<Munro> sortedList = dataParser.getParsedMunroList().filterMunroList(filterParams, filterNumbers);
        assertEquals("A' Bhuidheanach Bheag - Glas Mheall Mor", sortedList.get(0).getName());
    }
}