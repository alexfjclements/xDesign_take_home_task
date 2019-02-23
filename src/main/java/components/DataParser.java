package components;

import models.Munro;
import models.MunroList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class DataParser {
    private MunroList munroList = new MunroList();
//    private ArrayList<String> params = new ArrayList<String>();
    private String params;


    public void dataBuilder(String[] args) throws IOException {
        String fileName = "/Users/alexanderclements/Documents/projects/xDesign_takehome/munrotab_v6.2.csv";

        FileInputStream fileInputStream = new FileInputStream(fileName);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                parseLine(line);
            }
        }

//        Running No,DoBIH Number,Streetmap,Geograph,Hill-bagging,Name,SMC Section,RHB Section,_Section,Height (m),Height (ft),Map 1:50,Map 1:25,Grid Ref,GridRefXY,xcoord,ycoord,1891,1921,1933,1953,1969,1974,1981,1984,1990,1997,Post 1997,Comments

    }

    private String pathNameBuilder(String filename) {
        return "" + filename + ".csv";
    }

    private void addToList(ArrayList munroDetails) {
        Munro munroToAdd = new Munro(munroDetails);
        munroList.addMunro(munroToAdd);
//        params.clear();
    }

    private void parseLine(String line) {
        if (line.startsWith("Running")) {
            return;
        }

//        ArrayList<String> params = new ArrayList<>(Arrays.asList(line.split(",")));
        params = line;
        testReturnParams();
//        addToList(params);
    }

    public String testReturnParams(){
        return params;
    }

    public MunroList parsedMunroList() {
        return munroList;
    }
}
