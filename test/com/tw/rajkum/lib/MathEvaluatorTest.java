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
        assertEquals(9, new MathEvaluator().evaluateExpression("4 + 5"), 1);
    }
    @Test
    public void testSubtractUsingEvaluator() throws Exception {
        assertEquals(1, new MathEvaluator().evaluateExpression("6 - 5"), 1);
    }
    @Test
    public void testMultiplyUsingEvaluator() throws Exception {
        assertEquals(20, new MathEvaluator().evaluateExpression("4 * 5"), 1);
    }
    @Test
    public void testDivideUsingEvaluator() throws Exception {
        assertEquals(3, new MathEvaluator().evaluateExpression("19 / 6"), 1);
    }
    @Test
    public void testPowerUsingEvaluator() throws Exception {
        assertEquals(64, new MathEvaluator().evaluateExpression("4 ^ 3"), 1);
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

        assertEquals(expected, new MathEvaluator().evaluateExpression(input), 1);
    }
    @Test
    public void calculateExpressionWithMultipleOperatorsWithPower() {
        String input = "4* 3 ^2";
        double expected = 144.0;

        assertEquals(expected, new MathEvaluator().evaluateExpression(input), 1);
    }
    @Test
    public void calculateExpressionWithResultAsMultipleDigitsAfterDecimal() {
        String input = "22/7";
        double expected = 3.14;

        assertEquals(expected, new MathEvaluator().evaluateExpression(input), 1);
    }
//    @Test
//    public void getInnerExpression() {
//        String input = "2 + (3 + 4) + 5";
//        String expected = "(3 + 4)";
//
//        String inner = new MathEvaluator().getInnerExpression(input);
//        assertEquals(expected, inner);
//    }
//    @Test
//    public void getInnerExpressionIfNoBracket() {
//        String input = "2 + 3 + 4 + 5";
//        String expected = "(3 + 4)";
//
//        String inner = new MathEvaluator().getInnerExpression(input);
//        assertNull(inner);
//    }

//    @Test
//    public void getInnerExpressionWithMultipleBrackets() {
//        String input = "2 + (3 + 4) + 5";
//        List<String> expectedNumbers = new ArrayList<String>();
//        List<String> expectedOperators = new ArrayList<String>();
//        expectedNumbers.add("2");expectedNumbers.add("7");expectedNumbers.add("5");
//        expectedNumbers.add("+");expectedNumbers.add("+");
//        MathEvaluator test = new MathEvaluator();
//        List<Double> numbers = new ArrayList<Double>();
//        List<String> operators = new ArrayList<String>();
//        test.getNumbersAndOperators(input, numbers, operators);
//        assertEquals(expectedNumbers, numbers);
//        assertEquals(expectedOperators, operators);
//    }
}
