package com.munrolibrary.files.components;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DataParserTest {
    DataParser dataParser;

    @Before
    public void before() throws IOException {
        dataParser = new DataParser();
        dataParser.dataBuilder("munrotab_v6.2");
    }

    @Test
    public void getMunroListFromFile() {
        assertEquals(402, dataParser.getParsedMunroList().getFullMunroList().size());
    }

    @Test
    public void testMunroListSample() {
        assertEquals("Stuc a' Chroin", dataParser.getParsedMunroList().getFullMunroList().get(2).getName());
    }
}