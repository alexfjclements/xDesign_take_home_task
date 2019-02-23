package components;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class DataParserTest {
    DataParser dataParser;

    @Before
    public void before() throws IOException {
        dataParser = new DataParser();
        dataParser.dataBuilder();
    }

    @Test
    public void getMunroListFromFile() {
        assertEquals(402, dataParser.parsedMunroList().getMunroList().size());
    }
}