package com.munrolibrary.files.controllers;

import com.munrolibrary.files.components.DataParser;
import com.munrolibrary.files.models.Munro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/munros")

public class MunroController {

    @Autowired
    DataParser dataParser;

    @GetMapping(value = "/munros/all")
    public ArrayList<Munro> getAllMunros() throws IOException {
        dataParser = new DataParser();
        dataParser.dataBuilder("munrotab_v6.2");
        return dataParser.getParsedMunroList().getFullMunroList();
    }
}
