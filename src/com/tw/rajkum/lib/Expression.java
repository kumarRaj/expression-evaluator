package com.tw.rajkum.lib;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Expression {

    private List<Expression> numbers;
    private List<String> operators;
    private double value;

    public double getValue() {
        return value;
    }

    public Expression() {
        numbers = new LinkedList<>();
        operators = new LinkedList<>();
    }

    public Expression(double value) {
        this.value = value;
    }

    public static boolean areDoublesEqual(double a, double b){
        double DELTA = 0.0004;
        return a == b || Math.abs(a - b) < DELTA;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expression that = (Expression) o;
        return areDoublesEqual(this.getValue(),that.getValue());
    }

    public Expression parse(String expression) {
        String formattedExpression = parseInput(expression);
        String inner = getInnerExpression(formattedExpression);
        if (inner != null) {

            getNumbersAndOperators(inner.substring(1, inner.length() - 1));

            Expression result = calculate();
            formattedExpression = formattedExpression.replace(inner, String.valueOf(result.getValue()));
            return new Expression().parse(formattedExpression);
        }
        getNumbersAndOperators(formattedExpression);
        return this;
    }

    public String getInnerExpression(String array) {
        int start, end;
        start = array.indexOf("(");
        end = array.lastIndexOf(")");
        if (start == end)
            return null;
        return array.substring(start, end + 1);
    }

    public Expression calculate() {
        for (int i = 0; i < operators.size(); i++) {
            numbers.set(i + 1, new Expression(new MapOperator().
                    getResultOfOperation(operators.get(i),
                            numbers.get(i).getValue(),
                            numbers.get(i + 1).getValue())));
        }
        return numbers.get(numbers.size() - 1);
    }

    private void getNumbersAndOperators(String expression) {
        String input[] = expression.split(" ");
        String[] operatorsAllowed = {"+", "-", "*", "^", "/"};
        for (String s : input) {
            if (Arrays.asList(operatorsAllowed).indexOf(s) > -1)
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
