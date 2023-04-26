package com.example.calculatordemo.client;

import com.example.calculatordemo.math.Calculator;
import org.springframework.stereotype.Component;



public class CalcClient {

    private final Calculator calculator;

    public CalcClient(final Calculator calculator) {
        this.calculator = calculator;
    }

    public void go() {
        System.out.println(calculator.sub(3,4));
    }
}
