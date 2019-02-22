package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MunroTest {
    Munro munro;

    @Before
    public void before() {
        munro = new Munro("Ben More", 1245, MunroType.MUNRO, "NE6678383");
    }

    @Test
    public void getName() {
        assertEquals("Ben More", munro.getName());
    }

    // Issue with getHeight test relating to IntelliJ's ambiguous method call bug
    // https://intellij-support.jetbrains.com/hc/en-us/community/posts/360001797759-Ambiguous-method-call-bug
//    @Test
//    public void getHeight() {
//        assertEquals(1245, munro.getHeight());
//    }

    @Test
    public void getType() {
        assertEquals(MunroType.MUNRO, munro.getType());
    }

    @Test
    public void getGridReference() {
        assertEquals("NE6678383", munro.getGridReference());
    }
}