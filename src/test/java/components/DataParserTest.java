package components;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataParserTest {
    DataParser dataParser;

    @Before
    public void before() {
        dataParser = new DataParser();
    }

    @Test
    public void getMunroListFromFile() {
        assertEquals("602", dataParser.testReturnParams());
    }
}