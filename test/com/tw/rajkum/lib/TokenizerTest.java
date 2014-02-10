package com.tw.rajkum.lib;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is for
 */
public class TokenizerTest extends Assert{
        @Test
        public void testTokenizerWithOnlyOneOperator() {
            String expression = "+";
            Tokenizer tokenizer = new Tokenizer(expression);
            assertEquals(true, tokenizer.hasNext());
            assertEquals("+", tokenizer.next());
            assertEquals(false, tokenizer.hasNext());
        }

        @Test
        public void testWithTwoOperandsAndOneOperator() {
            String expression = "2+3";
            Tokenizer tokenizer = new Tokenizer(expression);
            assertEquals(true, tokenizer.hasNext());
            assertEquals("2", tokenizer.next());
            assertEquals("+", tokenizer.next());
            assertEquals("3", tokenizer.next());
        }

        @Test
        public void testWithMultipleDigitOperands(){
            String expression = "23+456";
            Tokenizer tokenizer = new Tokenizer(expression);
            assertEquals(true, tokenizer.hasNext());
            assertEquals("23", tokenizer.next());
            assertEquals("+", tokenizer.next());
            assertEquals("456", tokenizer.next());
        }

        @Test
        public void testTokenizerShouldAvoidEmptySpaces() {
            String expression ="  23 +   456";
            Tokenizer tokenizer = new Tokenizer(expression);
            assertEquals(true, tokenizer.hasNext());
            assertEquals("23", tokenizer.next());
            assertEquals("+", tokenizer.next());
            assertEquals("456", tokenizer.next());
            assertNull(tokenizer.next());
        }

        @Test
        public void testTokenizerNextMethodWhenNothingIsAvailable() {
            String expression = " ";
            Tokenizer tokenizer = new Tokenizer(expression);
            assertEquals(null, tokenizer.next());
        }

        @Test
        public void testTokenizerWhenBracketsAreGiven() {
            String expression = "22 + ( 33 * 44 ) ";
            Tokenizer tokenizer = new Tokenizer(expression);
            assertEquals("22", tokenizer.next());
            assertEquals("+", tokenizer.next());
            assertEquals("(", tokenizer.next());
            assertEquals("33", tokenizer.next());
            assertEquals("*", tokenizer.next());
            assertEquals("44", tokenizer.next());
            assertEquals(")", tokenizer.next());
            assertEquals(null, tokenizer.next());
            assertEquals(false, tokenizer.hasNext());
        }
    }
