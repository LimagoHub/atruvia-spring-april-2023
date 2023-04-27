package com.example.calculatordemo.math;


import org.springframework.stereotype.Component;


public class CalculatorImpl implements Calculator{

    // RoleAllowed("Admin")
    @Override
    public double add(final double a, final double b) {
        return a + b;
    }

    // RoleAllowed("Gast")
    @Override
    public double sub(final double a, final double b) {
        return add(a, -b);
    }
}
