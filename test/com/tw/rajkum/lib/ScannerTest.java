package com.tw.rajkum.lib;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is for
 */
public class ScannerTest extends Assert{
        @Test
        public void testTokenizerWithOnlyOneOperator() {
            String expression = "+";
            Scanner scanner = new Scanner(expression);
            assertEquals(true, scanner.hasNext());
            assertEquals("+", scanner.next());
            assertEquals(false, scanner.hasNext());
        }

        @Test
        public void testWithTwoOperandsAndOneOperator() {
            String expression = "2+3";
            Scanner scanner = new Scanner(expression);
            assertEquals(true, scanner.hasNext());
            assertEquals("2", scanner.next());
            assertEquals("+", scanner.next());
            assertEquals("3", scanner.next());
        }

        @Test
        public void testWithMultipleDigitOperands(){
            String expression = "23+456";
            Scanner scanner = new Scanner(expression);
            assertEquals(true, scanner.hasNext());
            assertEquals("23", scanner.next());
            assertEquals("+", scanner.next());
            assertEquals("456", scanner.next());
        }

        @Test
        public void testTokenizerShouldAvoidEmptySpaces() {
            String expression ="  23 +   456";
            Scanner scanner = new Scanner(expression);
            assertEquals(true, scanner.hasNext());
            assertEquals("23", scanner.next());
            assertEquals("+", scanner.next());
            assertEquals("456", scanner.next());
            assertNull(scanner.next());
        }

        @Test
        public void testTokenizerNextMethodWhenNothingIsAvailable() {
            String expression = " ";
            Scanner scanner = new Scanner(expression);
            assertEquals(null, scanner.next());
        }

        @Test
        public void testTokenizerWhenBracketsAreGiven() {
            String expression = "22 + ( 33 * 44 ) ";
            Scanner scanner = new Scanner(expression);
            assertEquals("22", scanner.next());
            assertEquals("+", scanner.next());
            assertEquals("(", scanner.next());
            assertEquals("33", scanner.next());
            assertEquals("*", scanner.next());
            assertEquals("44", scanner.next());
            assertEquals(")", scanner.next());
            assertEquals(null, scanner.next());
            assertEquals(false, scanner.hasNext());
        }
    }
