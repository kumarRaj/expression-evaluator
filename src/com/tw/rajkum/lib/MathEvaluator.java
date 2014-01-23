package com.tw.rajkum.lib;

import java.util.ArrayList;
import java.util.List;

public class MathEvaluator {

    int add(int num1, int num2){
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1/num2;
    }
    public int power(int base, int exponent) {
        return (int) Math.pow(base,exponent);
    }
    public int calculate(String expression) {
        String input[] = expression.split(" ");
        List<Integer> numbers = new ArrayList<Integer>();
        List<String> operators = new ArrayList<String>();

        getNumbersAndOperators(input, numbers, operators);
        for(int i = 0;i < operators.size();i++){
            if(operators.get(i).equals("+"))
                numbers.set(i + 1, add(numbers.get(i), numbers.get(i + 1)));
            if(operators.get(i).equals("-"))
                numbers.set(i + 1, subtract(numbers.get(i), numbers.get(i + 1)));
            if(operators.get(i).equals("*"))
                numbers.set(i + 1, multiply(numbers.get(i), numbers.get(i + 1)));
            if(operators.get(i).equals("/"))
                numbers.set(i + 1, divide(numbers.get(i), numbers.get(i + 1)));
            if(operators.get(i).equals("^"))
                numbers.set(i + 1, power(numbers.get(i), numbers.get(i + 1)));
        }
        return numbers.get(numbers.size() - 1);
    }

    private void getNumbersAndOperators(String[] input, List<Integer> numbers, List<String> operators) {
        for (String value : input) {
            try{
                numbers.add(Integer.parseInt(value));
            } catch (Exception ex){
                operators.add(value);
            }
        }
    }



}
