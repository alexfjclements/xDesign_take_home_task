package com.munrolibrary.files.components;

import com.munrolibrary.files.models.Munro;
import com.munrolibrary.files.models.MunroList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DataParser {
    @Autowired
    private MunroList munroList = new MunroList();

    @Autowired
    private ArrayList<String> params = new ArrayList<>();


    public void dataBuilder(String fileName) throws IOException {
        String filePath = pathNameBuilder(fileName);

        FileReader fileReader = new FileReader(filePath);

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                ArrayList<String> paramsList = new ArrayList<>(Arrays.asList(line.split(",")));
                parseLine(paramsList);
            }
        }
    }

    private String pathNameBuilder(String filename) {
        return "/Users/alexanderclements/Documents/projects/xDesign_takehome/" + filename + ".csv";
    }

    private void addToList(ArrayList munroDetails) {
        Munro munroToAdd = new Munro(munroDetails);
        munroList.addMunro(munroToAdd);
    }

    private void parseLine(ArrayList<String> line) {
        if (line.size() != 29 || line.get(0).startsWith("Running No") || line.get(28) == "") {
            return;
        } else {
            params = line;
            addToList(params);
        }
    }

    public MunroList getParsedMunroList() {
        return munroList;
    }
}