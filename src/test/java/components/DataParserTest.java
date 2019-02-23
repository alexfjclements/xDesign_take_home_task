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
        assertEquals("602", dataParser.testReturnParams());
    }
}