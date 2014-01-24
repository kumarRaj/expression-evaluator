package com.tw.rajkum.lib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathEvaluatorTest {
    @Test
    public void testAddWithOperator() throws Exception {
        assertEquals(11, new MapOperator().getResultOfOperation("+", 5, 6), 0.5);
    }
    @Test
    public void testSubtractWithOperator() throws Exception {
        assertEquals(-1, new MapOperator().getResultOfOperation("-", 5, 6), 0.5);
    }
    @Test
    public void testMultiplyWithOperator() throws Exception {
        assertEquals(30, new MapOperator().getResultOfOperation("*", 5, 6), 0.5);
    }
    @Test
    public void testDivideWithOperator() throws Exception {
        assertEquals(6, new MapOperator().getResultOfOperation("/", 36, 6), 0.5);
    }
    @Test
    public void testPowerWithOperator() throws Exception {
        assertEquals(25, new MapOperator().getResultOfOperation("^", 5, 2), 0.5);
    }
    @Test
    public void testAddUsingEvaluator() throws Exception {
        assertEquals(9, new MathEvaluator().evaluateExpression("4 + 5"), 0.5);
    }
    @Test
    public void testSubtractUsingEvaluator() throws Exception {
        assertEquals(1, new MathEvaluator().evaluateExpression("6 - 5"), 0.5);
    }
    @Test
    public void testMultiplyUsingEvaluator() throws Exception {
        assertEquals(20, new MathEvaluator().evaluateExpression("4 * 5"), 0.5);
    }
    @Test
    public void testDivideUsingEvaluator() throws Exception {
        assertEquals(3, new MathEvaluator().evaluateExpression("19 / 6"), 0.5);
    }
    @Test
    public void testPowerUsingEvaluator() throws Exception {
        assertEquals(64, new MathEvaluator().evaluateExpression("4 ^ 3"), 0.5);
    }
    @Test
    public void testTrimSpacesOnRightOfExpression() {
        String input = "4 + 4  ";
        String expected = "4 + 4";

        assertEquals(expected,new MathEvaluator().parseInput(input));
    }
    @Test
    public void testTrimSpacesOnLeftOfExpression() {
        String input = "   4 + 4  ";
        String expected = "4 + 4";

        assertEquals(expected,new MathEvaluator().parseInput(input));
    }
    @Test
    public void testRemoveExtraSpacesInBetweenExpression() {
        String input = "   4 +   4  ";
        String expected = "4 + 4";

        assertEquals(expected,new MathEvaluator().parseInput(input));
    }
    @Test
    public void testAddSpacesIfNoSpacesInExpressionForPlus() {
        String input = "4+4";
        String expected = "4 + 4";

        assertEquals(expected,new MathEvaluator().parseInput(input));
    }
    @Test
    public void testAddSpacesIfNoSpacesInExpressionForMinus() {
        String input = "4-4";
        String expected = "4 - 4";

        assertEquals(expected,new MathEvaluator().parseInput(input));
    }
    @Test
    public void parseIncorrectExpression() {
        String input = "4*   78 + 98/2";
        String expected = "4 * 78 + 98 / 2";

        assertEquals(expected,new MathEvaluator().parseInput(input));
    }
    @Test
    public void parseNegativeNumber() {
        String input = "4--2";
        String expected = "4 - -2";

        assertEquals(expected,new MathEvaluator().parseInput(input));
    }
    @Test
    public void parseNegativeNumberInStartingOfExpression() {
        String input = "-4--2";
        String expected = "-4 - -2";

        assertEquals(expected,new MathEvaluator().parseInput(input));
    }
    @Test
    public void calculateExpressionWithMultipleOperators() {
        String input = "4*   7 + 9 -2";
        double expected = 35.0;

        assertEquals(expected, new MathEvaluator().evaluateExpression(input), 0.5);
    }
    @Test
    public void calculateExpressionWithMultipleOperatorsWithPower() {
        String input = "4* 3 ^2";
        double expected = 144.0;

        assertEquals(expected, new MathEvaluator().evaluateExpression(input), 0.5);
    }
    @Test
    public void calculateExpressionWithResultAsMultipleDigitsAfterDecimal() {
        String input = "22/7";
        double expected = 3.14;

        assertEquals(expected, new MathEvaluator().evaluateExpression(input), 0.5);
    }

    @Test
    public void getInnerExpression() {
        String input = "2 + (3 + 4) + 5";
        String expected = "(3 + 4)";

        String inner = new MathEvaluator().getInnerExpression(input);
        assertEquals(expected, inner);
    }

    @Test
    public void evaluateExpressionWithBrackets() {
        String input = "2 + (3 + 4) + 5";
        double expected = 14;

        assertEquals(expected, new MathEvaluator().evaluateExpression(input), 0.5);
    }

    @Test
    public void evaluateExpressionWithMultipleBrackets() {
        String input = "2 + (3 + 4) + (2-3)- 5";
        double expected = 3;

        assertEquals(expected, new MathEvaluator().evaluateExpression(input), 0.5);
    }

    @Test
    public void evaluateExpressionWithBracketsWithinBrackets() {
        String input = "2 + (4 + (4 + 2)-3)- 5";
        double expected = 3;

        assertEquals(expected, new MathEvaluator().evaluateExpression(input), 0.5);
    }

    @Test
    public void testMohit() {
        String input = "(4-(((5.5)+12)*10)-1)";
        double expected = -172;

        assertEquals(expected, new MathEvaluator().evaluateExpression(input), 0.5);
    }

    @Test
    public void testNegative1() {
        String input = "(-1)";
        double expected = -1;

        assertEquals(expected, new MathEvaluator().evaluateExpression(input), 0.5);
    }

    @Test
    public void testNegative2() {
        String input = "((-1)-(-1))";
        double expected = 0;

        assertEquals(expected, new MathEvaluator().evaluateExpression(input), 0.5);
    }

}
