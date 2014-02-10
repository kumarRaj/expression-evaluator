package com.tw.rajkum.lib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionTest {
    @Test
    public void testAddWithOperator() {
        assertEquals(11, new MapOperator().getResultOfOperation("+", 5, 6), 0.5);
    }

    @Test
    public void testSubtractWithOperator() {
        double resultOfOperation = new MapOperator().getResultOfOperation("-", 5, 6);
        assertEquals(-1, resultOfOperation, 0.5);
    }

    @Test
    public void testMultiplyWithOperator() {
        double resultOfOperation = new MapOperator().getResultOfOperation("*", 5, 6);
        assertEquals(30, resultOfOperation, 0.5);
    }

    @Test
    public void testDivideWithOperator() {
        double resultOfOperation = new MapOperator().getResultOfOperation("/", 30, 5);
        assertEquals(6, resultOfOperation, 0.5);
    }

    @Test
    public void testPowerWithOperator() {
        double resultOfOperation = new MapOperator().getResultOfOperation("^", 5, 2);
        assertEquals(25, resultOfOperation, 0.5);
    }

    @Test
    public void testEqualsOfExpression() {
        Expression ex1 = new Expression(1.0);
        Expression ex2 = new Expression(1.0);
        assertEquals(true, ex1.equals(ex2));
    }

    @Test
    public void testUnEqualityOfExpression() {
        Expression ex1 = new Expression(1.0);
        Expression ex2 = new Expression(2.0);
        assertEquals(false, ex1.equals(ex2));
    }

    @Test
    public void testAddUsingEvaluator() {
        Expression toParse = new Expression().parse("4 + 5");
        assertEquals(new Expression(9), toParse.calculate());
    }

    @Test
    public void testSubtractUsingEvaluator() {
        Expression toParse = new Expression().parse("6 - 5");
        assertEquals(new Expression(1), toParse.calculate());
    }

//    @Test
//    public void testParsingOfInnerExpression() {
//        String exp = "2 + (3 * (4 + 6) + 7)";
//        Expression toParse = new Expression().parse(exp);
//    }
    //
//    @Test
//    public void testMultiplyUsingEvaluator()   {
//        assertEquals(20, new Expression().parse("4 * 5"), 0.5);
//    }
//
//    @Test
//    public void testDivideUsingEvaluator()   {
//        assertEquals(3, new Expression().parse("19 / 6"), 0.5);
//    }
//
//    @Test
//    public void testPowerUsingEvaluator()   {
//        assertEquals(64, new Expression().parse("4 ^ 3"), 0.5);
//    }

    @Test
    public void testTrimSpacesOnRightOfExpression() {
        String input = "4 + 4  ";
        String expected = "4 + 4";

        assertEquals(expected, new Expression().parseInput(input));
    }

    @Test
    public void testTrimSpacesOnLeftOfExpression() {
        String input = "   4 + 4  ";
        String expected = "4 + 4";

        assertEquals(expected, new Expression().parseInput(input));
    }

    @Test
    public void testRemoveExtraSpacesInBetweenExpression() {
        String input = "   4 +   4  ";
        String expected = "4 + 4";

        assertEquals(expected, new Expression().parseInput(input));
    }

    @Test
    public void testAddSpacesIfNoSpacesInExpressionForPlus() {
        String input = "4+4";
        String expected = "4 + 4";

        assertEquals(expected, new Expression().parseInput(input));
    }

    @Test
    public void testAddSpacesIfNoSpacesInExpressionForMinus() {
        String input = "4-4";
        String expected = "4 - 4";

        assertEquals(expected, new Expression().parseInput(input));
    }

    @Test
    public void parseIncorrectExpression() {
        String input = "4*   78 + 98/2";
        String expected = "4 * 78 + 98 / 2";

        assertEquals(expected, new Expression().parseInput(input));
    }

    @Test
    public void parseNegativeNumber() {
        String input = "4--2";
        String expected = "4 - -2";

        assertEquals(expected, new Expression().parseInput(input));
    }

    @Test
    public void parseNegativeNumberInStartingOfExpression() {
        String input = "-4--2";
        String expected = "-4 - -2";

        assertEquals(expected, new Expression().parseInput(input));
    }

//    @Test
//    public void calculateExpressionWithMultipleOperators() {
//        String input = "4*   7 + 9 -2";
//        double expected = 35.0;
//
//        assertEquals(expected, new Expression().parse(input), 0.5);
//    }
//
//    @Test
//    public void calculateExpressionWithMultipleOperatorsWithPower() {
//        String input = "4* 3 ^2";
//        double expected = 144.0;
//
//        assertEquals(expected, new Expression().parse(input), 0.5);
//    }
//
//    @Test
//    public void calculateExpressionWithResultAsMultipleDigitsAfterDecimal() {
//        String input = "22/7";
//        double expected = 3.14;
//
//        assertEquals(expected, new Expression().parse(input), 0.5);
//    }

//    @Test
//    public void getInnerExpression() {
//        String input = "2 + (3 + 4) + 5";
//        String expected = "(3 + 4)";
//
//        String inner = new Expression().getInnerExpression(input);
//        assertEquals(expected, inner);
//    }
//
//    @Test
//    public void evaluateExpressionWithBrackets() {
//        String input = "2 + (3 + 4) + 5";
//        double expected = 14;
//
//        assertEquals(expected, new Expression().parse(input), 0.5);
//    }
//
//    @Test
//    public void evaluateExpressionWithMultipleBrackets() {
//        String input = "2 + (3 + 4) + (2-3)- 5";
//        double expected = 3;
//
//        assertEquals(expected, new Expression().parse(input), 0.5);
//    }
//
//    @Test
//    public void evaluateExpressionWithBracketsWithinBrackets() {
//        String input = "2 + (4 + (4 + 2)-3)- 5";
//        double expected = 4;
//
//        assertEquals(expected, new Expression().parse(input), 0.5);
//    }
//
//    @Test
//    public void testMohit() {
//        String input = "(4-(((5.5)+12)*10)-1)";
//        double expected = -172;
//
//        assertEquals(expected, new Expression().parse(input), 0.5);
//    }
//
//    @Test
//    public void testNegative1() {
//        String input = "(-1)";
//        double expected = -1;
//
//        assertEquals(expected, new Expression().parse(input), 0.5);
//    }
//
//    @Test
//    public void testNegative2() {
//        String input = "((-1)-(-1))";
//        double expected = 0;
//
//        assertEquals(expected, new Expression().parse(input), 0.5);
//    }
//
//    @Test
//    public void testPrajakta() {
//        String input = "1.25 -- 0.25";
//        double expected = 1.5;
//
//        assertEquals(expected, new Expression().parse(input), 0.5);
//    }

}
