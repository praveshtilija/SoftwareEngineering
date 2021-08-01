package edu.qc.seclass;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class BuggyClassTestSC2 {

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
    public void buggyMethod2() {
        assertEquals(2, my_BuggyClass.buggyMethod2(2, 1));
    }

}
