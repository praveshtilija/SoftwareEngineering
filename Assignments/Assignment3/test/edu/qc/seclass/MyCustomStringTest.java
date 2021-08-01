package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test	//Test for no digits in the string
    public void testCountNumbers2() {
        mycustomstring.setString("hello world, there is no digits in this string");
        assertEquals(0, mycustomstring.countNumbers());
    }

    //Test for null
    @Test (expected = NullPointerException.class)
    public void testCountNumbers3() {
    	mycustomstring.setString(null);  
    	mycustomstring.countNumbers();        
    }

    @Test	//Test for empty string
    public void testCountNumbers4() {
    	mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test	//Test for digits when it is separated
    public void testCountNumbers5() {
    	mycustomstring.setString("Digits 59 and 456");
 	   	assertEquals(2, mycustomstring.countNumbers());
    }

    @Test	//Test for digits when it is separated and consecutive
    public void testCountNumbers6() {
    	mycustomstring.setString("testing 123 321, testing 321 and 345");
        assertEquals(4, mycustomstring.countNumbers());
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    //Test for n <= 0, startFromEnd = false
    @Test (expected=IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
    	mycustomstring.setString("Hello world");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false);
    }

    @Test	//Test for empty string
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
    	mycustomstring.setString("");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    //Test for null, startFromEnd = false
    @Test (expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
    	mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false);
    }

    @Test	//Test for printing only numbers
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
    	mycustomstring.setString("5 6 8 7 3 4 8 3 1");
        assertEquals("568734831", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    @Test	//Test for printing spaces
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
    	mycustomstring.setString("5 6 8 7 3 4 8 3 1");
        assertEquals("         ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    @Test	//Test for outcome
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
    	mycustomstring.setString("Hello World");
        assertEquals("el ol", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    @Test	//Test for returning empty string if length less than n 
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
    	mycustomstring.setString("gh");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test	//Test for printing out string by itteration
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
    	mycustomstring.setString("Print this out");
        assertEquals("Print this out", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }

    @Test	//Test for outcome is empty if n bigger than string length
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
    	mycustomstring.setString("RandomString");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(12, true));
    }

    //Test for null when string is null and n is greater than 0, startFromEnd=true
    @Test (expected=NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
    	mycustomstring.setString(null);  
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true);  
    }

  //Test for null, startFromEnd = true
    @Test (expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
    	mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true);
    }

    //Test for n <= 0, startFromEnd = true
    @Test (expected=IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
    	mycustomstring.setString("Hello world");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    //Test for out of bounds exception
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring2() {
    	mycustomstring.setString("testing");
        mycustomstring.convertDigitsToNamesInSubstring(0,9);
    }

    //Test for index out of bounds
    @Test (expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring3() {
    	mycustomstring.setString("testing");
        mycustomstring.convertDigitsToNamesInSubstring(1,mycustomstring.getString().length() + 1);
    }

    //Test startingpoint > endingpoint
    @Test (expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring4() {
    	mycustomstring.setString("testing");
        mycustomstring.convertDigitsToNamesInSubstring(12,9);
    }

    //Test for null
    @Test (expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring5() {
    	mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(1,2);
    }

    @Test	//Test for special keys
    public void testConvertDigitsToNamesInSubstring6() {
    	mycustomstring.setString("testing9@6 7 8-9");
        mycustomstring.convertDigitsToNamesInSubstring(1, 15);
        assertEquals("testingNine@Six Seven Eight-Nine", mycustomstring.getString());
    }

    @Test	//Test for spacing
    public void testConvertDigitsToNamesInSubstring7() {
    	mycustomstring.setString(" ");
        mycustomstring.convertDigitsToNamesInSubstring(1,1);
    }

    @Test	//Test method
    public void testConvertDigitsToNamesInSubstring8() {
    	mycustomstring.setString("testing93 81");
        mycustomstring.convertDigitsToNamesInSubstring(1, 15);
        assertEquals("testingNineThree EigthOne", mycustomstring.getString());
    }

}