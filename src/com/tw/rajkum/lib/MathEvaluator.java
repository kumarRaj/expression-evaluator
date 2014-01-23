package com.tw.rajkum.lib;

import java.util.ArrayList;
import java.util.List;

public class MathEvaluator {

    public String evaluateExpression(String expression){
        String formattedExpression = parseInput(expression);
        Double result = calculate(formattedExpression);
        String stringResult = result.toString();
        int indexOfPoint = stringResult.indexOf('.');
        try{
            return stringResult.substring(0, indexOfPoint + 3);
        } catch (StringIndexOutOfBoundsException ex){
            return stringResult;
        }
    }

    public double calculate(String expression) {
        String input[] = expression.split(" ");
        List<Double> numbers = new ArrayList<Double>();
        List<String> operators = new ArrayList<String>();
        getNumbersAndOperators(input, numbers, operators);
        for (int i = 0; i < operators.size(); i++) {
            numbers.set(i + 1, new MapOperator().getResultOfOperation(operators.get(i), numbers.get(i), numbers.get(i + 1)));
        }
        return numbers.get(numbers.size() - 1);
    }

    private void getNumbersAndOperators(String[] input, List<Double> numbers, List<String> operators) {
        for (String value : input) {
            try {
                numbers.add(Double.parseDouble(value));
            } catch (Exception ex) {
                operators.add(value);
            }
        }
    }

    public String parseInput(String input) {
        return input.trim().replaceAll(" +", "")
                .replaceAll("\\+", " + ")
                .replaceAll("\\-"," - ")
                .replaceAll("\\*", " * ")
                .replaceAll("\\/", " / ")
                .replaceAll("\\^", " ^ ")
                .replaceAll("  - ", " -")
                .replaceFirst("^ - ", "-");
    }
}
