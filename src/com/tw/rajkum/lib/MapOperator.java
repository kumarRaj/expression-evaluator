package com.tw.rajkum.lib;

import java.util.HashMap;
import java.util.Map;

public class MapOperator {
    Expression getResultOfOperation(String operator, Expression a, Expression b) {
        Map<String, Operator> operators = new HashMap<String, Operator>();
        operators.put("+", new Operator() {
            @Override
            public Expression operation(Expression a, Expression b) {
                return new Expression(a.getValue() + b.getValue());
            }
        });
        operators.put("-", new Operator() {
            @Override
            public Expression operation(Expression a, Expression b) {
                return new Expression(a.getValue() - b.getValue());
            }
        });
        operators.put("*", new Operator() {
            @Override
            public Expression operation(Expression a, Expression b) {
                return new Expression(a.getValue() * b.getValue());
            }
        });
        operators.put("/", new Operator() {
            @Override
            public Expression operation(Expression a, Expression b) {
                return new Expression(a.getValue() / b.getValue());
            }
        });
        operators.put("^", new Operator() {
            @Override
            public Expression operation(Expression a, Expression b) {
                return new Expression(Math.pow(a.getValue(), b.getValue()));
            }
        });
        return operators.get(operator).operation(a, b);
    }
}
