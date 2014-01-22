package com.tw.rajkum.lib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathEvaluatorTest {
    @Test
    public void testAdd() throws Exception {
        assertEquals(9,new MathEvaluator().add(4,5));
    }
    @Test
    public void testAddUsingEvaluator() throws Exception {
        assertEquals(9,new MathEvaluator().calculate("4 + 5"));
    }
}
