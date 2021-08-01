package edu.qc.seclass;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class BuggyClassTestSC1b {

	BuggyClass my_BuggyClass;

    @Before
    public void init() {
        my_BuggyClass= new BuggyClass();
    }

    @After          
    public void terminate() {
        my_BuggyClass = null;
    }

    @Test
    public void buggyMethod1() {
        assertEquals(2, my_BuggyClass.buggyMethod1(2, 2));
    }
}
