package com.tw.rajkum.cli;

import com.tw.rajkum.lib.MathEvaluator;

public class Evaluator {
    public static void main(String[] args) {
        MathEvaluator evaluator = new MathEvaluator();
        String formattedInput = evaluator.parseInput(args[0]);
        System.out.println(evaluator.calculate(formattedInput));
    }
}
