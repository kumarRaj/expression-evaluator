package com.tw.rajkum.lib;

import java.util.HashMap;
import java.util.Map;

public class MapOperator {
    double getResultOfOperation(String operator,double a,double b){
        Map<String,Operator> operators = new HashMap<String, Operator>();
        operators.put("+",new Operator() {
            @Override
            public double operation(double a, double b) {
                return a + b;
            }
        });
        operators.put("-",new Operator() {
            @Override
            public double operation(double a, double b) {
                return a - b;
            }
        });
        operators.put("*",new Operator() {
            @Override
            public double operation(double a, double b) {
                return a * b;
            }
        });
        operators.put("/",new Operator() {
            @Override
            public double operation(double a, double b) {
                return a / b;
            }
        });
        operators.put("^",new Operator() {
            @Override
            public double operation(double a, double b) {
                return Math.pow(a,b);
            }
        });
        return operators.get(operator).operation(a,b);
    }
}
