package components;

import models.Munro;
import models.MunroList;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DataParser {
    private MunroList munroList = new MunroList();
    private ArrayList<String> params = new ArrayList<>();


    public void dataBuilder() throws IOException {
        String fileName = "/Users/alexanderclements/Documents/projects/xDesign_takehome/munrotab_v6.2.csv";

        FileReader fileReader = new FileReader(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                ArrayList<String> paramsList = new ArrayList<>(Arrays.asList(line.split(",")));
                parseLine(paramsList);
            }
        }
    }

    private String pathNameBuilder(String filename) {
        return "" + filename + ".csv";
    }

    private void addToList(ArrayList munroDetails) {
        Munro munroToAdd = new Munro(munroDetails);
        munroList.addMunro(munroToAdd);
    }

    private void parseLine(ArrayList<String> line) {
        if (line.size() != 29 || line.get(0).startsWith("Running No")) {
            return;
        } else {

            params = line;
            addToList(params);
        }
    }

    public MunroList parsedMunroList() {
        return munroList;
    }
}
