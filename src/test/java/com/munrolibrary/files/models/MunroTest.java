package com.munrolibrary.files.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class MunroTest {
    Munro munro;

    @Before
    public void before() {
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
    }

    @Test
    public void getName() {
        assertEquals("Ben Chonzie", munro.getName());
    }

    // Issue with getHeight test relating to IntelliJ's ambiguous method call bug
    // https://intellij-support.jetbrains.com/hc/en-us/community/posts/360001797759-Ambiguous-method-call-bug
    // workaround by converting height to string for the test
    @Test
    public void getHeight() {
        assertEquals("931.0", munro.getHeight().toString());
    }

    @Test
    public void getType() {
        assertEquals(MunroType.MUNRO, munro.getType());
    }

    @Test
    public void getGridReference() {
        assertEquals("NN773308", munro.getGridReference());
    }
}