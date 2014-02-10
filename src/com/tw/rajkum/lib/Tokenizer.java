package com.tw.rajkum.lib;

/**
 * This is for reading input character by character and reading only supported characters.
 * It gives back tokens.
 */

import java.util.Arrays;
import java.util.List;

public class Tokenizer {
    private String expression;
    int index;
    Character[] operators = {'+', '-', '*', '/', '^', '(', ')'};
    Character[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    List<Character> operatorsList = Arrays.asList(operators);
    List<Character> numberList = Arrays.asList(numbers);

    public Tokenizer(String expression) {
        this.expression = expression;
        index = 0;
    }

    public boolean hasNext() {
        int length = expression.length();
        return index != length;
    }

    public String next() {
        if (!hasNext())
            return null;
        char nextCharacter = expression.charAt(index);
        if (nextCharacter == ' ') {
            index++;
            return next();
        }
        if (operatorsList.contains(nextCharacter)) {
            index++;
            return String.valueOf(nextCharacter);
        }
        int startIndex = index;
        while (hasNext() && isNumber()) {
            index++;
        }
        return expression.substring(startIndex, index);
    }

    private boolean isNumber() {
        return numberList.contains(expression.charAt(index));
    }
}