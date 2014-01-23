package com.tw.rajkum.cli;

import com.tw.rajkum.lib.MathEvaluator;

public class Evaluator {
    public static void main(String[] args) {
        System.out.println(new MathEvaluator().evaluateExpression(args[0]));
    }
}
