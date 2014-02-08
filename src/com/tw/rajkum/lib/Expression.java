package com.tw.rajkum.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Expression {

    private List<Expression> numbers;
    private List<String> operators;
    private double value;

    public double getValue() {
        return value;
    }

    public Expression() {
        numbers = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public Expression(double value) {
        this.value = value;
    }

    public double evaluate(String expression) {
        String formattedExpression = parseInput(expression);
        String inner = getInnerExpression(formattedExpression);
        if (inner != null) {
            getNumbersAndOperators(inner.substring(1, inner.length() - 1));
            Expression result = calculate();
            formattedExpression = formattedExpression.replace(inner, String.valueOf(result.getValue()));
            return new Expression().evaluate(formattedExpression);
        }
        getNumbersAndOperators(formattedExpression);
        return calculate().value;
    }

    public String getInnerExpression(String array) {
        char s;
        int start = 0, end = 0;
        for (int i = 0; i < array.length(); i++) {
            s = array.charAt(i);
            if (s == '(')
                start = i;
            if (s == ')') {
                end = i;
                break;
            }
        }
        if (start == end)
            return null;
        return array.substring(start, end + 1);
    }

    private Expression calculate() {
        for (int i = 0; i < operators.size(); i++) {
            numbers.set(i + 1, new MapOperator().
                    getResultOfOperation(operators.get(i), numbers.get(i), numbers.get(i + 1)));
        }
        return numbers.get(numbers.size() - 1);
    }

    public void getNumbersAndOperators(String expression) {
        String input[] = expression.split(" ");
        String[] operatorsAllowed = {"+","-","*","^","/"};
        for (String s : input) {
            if(Arrays.asList(operatorsAllowed).indexOf(s) > -1)
                operators.add(s);
            else
                numbers.add(new Expression(Double.parseDouble(s)));
        }
    }

    public String parseInput(String input) {
        return input.trim().replaceAll(" +", "")
                .replaceAll("\\+", " + ")
                .replaceAll("\\-", " - ")
                .replaceAll("\\*", " * ")
                .replaceAll("\\/", " / ")
                .replaceAll("\\^", " ^ ")
                .replaceAll("  - ", " -")
                .replaceAll("\\( - ", "(-")
                .replaceFirst("^ - ", "-");
    }
}
