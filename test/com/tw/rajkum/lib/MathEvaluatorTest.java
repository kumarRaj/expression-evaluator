package com.tw.rajkum.lib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathEvaluatorTest {
    @Test
    public void testAddWithOperator() throws Exception {
        assertEquals(11,new MapOperator().getResultOfOperation("+", 5, 6),1);
    }
    @Test
    public void testSubtractWithOperator() throws Exception {
        assertEquals(-1,new MapOperator().getResultOfOperation("-", 5, 6),1);
    }
    @Test
    public void testMultiplyWithOperator() throws Exception {
        assertEquals(30,new MapOperator().getResultOfOperation("*", 5, 6),1);
    }
    @Test
    public void testDivideWithOperator() throws Exception {
        assertEquals(6,new MapOperator().getResultOfOperation("/", 36, 6),1);
    }
    @Test
    public void testPowerWithOperator() throws Exception {
        assertEquals(25,new MapOperator().getResultOfOperation("^", 5, 2),1);
    }
    @Test
    public void testAddUsingEvaluator() throws Exception {
        assertEquals(9,new MathEvaluator().calculate("4 + 5"),1);
    }
    @Test
    public void testSubtractUsingEvaluator() throws Exception {
        assertEquals(1,new MathEvaluator().calculate("6 - 5"),1);
    }
    @Test
    public void testMultiplyUsingEvaluator() throws Exception {
        assertEquals(20,new MathEvaluator().calculate("4 * 5"),1);
    }
    @Test
    public void testDivideUsingEvaluator() throws Exception {
        assertEquals(3,new MathEvaluator().calculate("19 / 6"),1);
    }
    @Test
    public void testPowerUsingEvaluator() throws Exception {
        assertEquals(64,new MathEvaluator().calculate("4 ^ 3"),1);
    }
}
