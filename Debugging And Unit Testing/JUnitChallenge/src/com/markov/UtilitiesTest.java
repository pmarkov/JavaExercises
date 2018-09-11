package com.markov;

import static org.junit.Assert.*;

public class UtilitiesTest {

    private Utilities util;

    @org.junit.Before
    public void setup() {
        util = new Utilities();
    }

    @org.junit.Test
    public void everyNthChar() {
        char[] test = {'h', 'e', 'l', 'l', 'o'};
        assertArrayEquals(new char[] {'e', 'l'}, util.everyNthChar(test, 2));

        char[] result = util.everyNthChar(test, 6);
        assertArrayEquals(test, result);
    }

    @org.junit.Test
    public void removePairs() {

        String str1 = util.removePairs("AABCDDEFF");
        assertEquals("ABCDEF", str1);

        String str2 = util.removePairs("ABCCBDEEF");
        assertEquals("ABCBDEF", str2);
        assertEquals("12345", util.removePairs("111234555"));

        assertNull(util.removePairs(null));
        assertEquals("A", util.removePairs("AA"));
    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void converter_arithmeticException() {
        util.converter(10, 0);
    }

    @org.junit.Test
    public void converter() {
        assertEquals(300, util.converter(10, 5));
    }

    @org.junit.Test
    public void nullIfOddLength() {
        assertNotNull("This test should haven't returned null because the length is even.",util.nullIfOddLength("123456"));
        assertNull("This test should've returned null because the length is odd.", util.nullIfOddLength("12345"));
    }
}