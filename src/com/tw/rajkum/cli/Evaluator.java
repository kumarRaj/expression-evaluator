package com.tw.rajkum.cli;

import com.tw.rajkum.lib.Expression;

public class Evaluator {
    public static void main(String[] args) {
        System.out.println(new Expression().parse(args[0]));
    }
}
