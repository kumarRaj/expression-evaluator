package com.tw.rajkum.lib;

import java.util.ArrayList;
import java.util.List;

public class Expression {

    private final List<Double> numbers;
    private final List<String> operators;

    public Expression() {
        numbers = new ArrayList<Double>();
        operators = new ArrayList<String>();
    }

    public double evaluate(String expression) {
        String formattedExpression = parseInput(expression);
        String inner = getInnerExpression(formattedExpression);
        if (inner != null) {
            getNumbersAndOperators(inner.substring(1, inner.length() - 1));
            Double result = calculate();
            formattedExpression = formattedExpression.replace(inner, result.toString());
            return new Expression().evaluate(formattedExpression);
        }
        getNumbersAndOperators(formattedExpression);
        return calculate();
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

    private double calculate() {
        for (int i = 0; i < operators.size(); i++) {
            numbers.set(i + 1, new MapOperator().
                    getResultOfOperation(operators.get(i), numbers.get(i), numbers.get(i + 1)));
        }
        return numbers.get(numbers.size() - 1);
    }

    public void getNumbersAndOperators(String expression) {
        String input[] = expression.split(" ");
        for (String s : input) {
            try {
                numbers.add(Double.parseDouble(s));
            } catch (Exception ex) {
                operators.add(s);
            }
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
