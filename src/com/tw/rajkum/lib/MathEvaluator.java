package com.tw.rajkum.lib;

import java.util.ArrayList;
import java.util.List;

public class MathEvaluator {

    public double evaluateExpression(String expression) {
        String formattedExpression = parseInput(expression);
        List<Double> numbers = new ArrayList<Double>();
        List<String> operators = new ArrayList<String>();
        String inner = getInnerExpression(formattedExpression);
        if (inner != null) {
            System.out.println(inner);
            getNumbersAndOperators(inner.substring(1, inner.length() - 1), numbers, operators);
            Double result = calculate(numbers, operators);
            formattedExpression = formattedExpression.replace(inner, result.toString());
            System.out.println(formattedExpression);
            return evaluateExpression(formattedExpression);
        }
        getNumbersAndOperators(formattedExpression, numbers, operators);
        return calculate(numbers, operators);
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

    public double calculate(List<Double> numbers, List<String> operators) {
        for (int i = 0; i < operators.size(); i++) {
            numbers.set(i + 1, new MapOperator().getResultOfOperation(operators.get(i), numbers.get(i), numbers.get(i + 1)));
        }
        return numbers.get(numbers.size() - 1);
    }

    public void getNumbersAndOperators(String expression, List<Double> numbers, List<String> operators) {
//        String inner = getInnerExpression(expression);
//        if(expression.contains("(")){
//            getNumbersAndOperators(inner.substring(1,inner.length()-1),numbers,operators);
//            double result = calculate(inner);
//            expression.replace(inner," " + result + " ");
//        }
//        if(inner != null){
//            calculate(inner);
//        }
        String input[] = expression.split(" ");
        for (int i = 0; i < input.length; i++) {
            String s = input[i];
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
                .replaceAll("\\-"," - ")
                .replaceAll("\\*", " * ")
                .replaceAll("\\/", " / ")
                .replaceAll("\\^", " ^ ")
                .replaceAll("  - ", " -")
                .replaceFirst("^ - ", "-");
    }
}
