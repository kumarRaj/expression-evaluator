package com.tw.rajkum.lib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathEvaluatorTest {
    @Test
    public void testAdd() throws Exception {
        assertEquals(9,new MathEvaluator().add(4,5));
    }
    @Test
    public void testSubtract() throws Exception {
        assertEquals(4,new MathEvaluator().subtract(9, 5));
    }
    @Test
    public void testMultiply() throws Exception {
        assertEquals(45,new MathEvaluator().multiply(9, 5));
    }
    @Test
    public void testDivide() throws Exception {
        assertEquals(3,new MathEvaluator().divide(22, 7));
    }
    @Test
    public void testPower() throws Exception {
        assertEquals(1024,new MathEvaluator().power(2, 10));
    }
    @Test
    public void testAddUsingEvaluator() throws Exception {
        assertEquals(9,new MathEvaluator().calculate("4 + 5"));
    }
    @Test
    public void testSubtractUsingEvaluator() throws Exception {
        assertEquals(1,new MathEvaluator().calculate("6 - 5"));
    }
    @Test
    public void testMultiplyUsingEvaluator() throws Exception {
        assertEquals(20,new MathEvaluator().calculate("4 * 5"));
    }
    @Test
    public void testDivideUsingEvaluator() throws Exception {
        assertEquals(3,new MathEvaluator().calculate("19 / 6"));
    }
    @Test
    public void testPowerUsingEvaluator() throws Exception {
        assertEquals(64,new MathEvaluator().calculate("4 ^ 3"));
    }
}
