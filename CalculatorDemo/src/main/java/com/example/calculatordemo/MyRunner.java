package com.example.calculatordemo;

import com.example.calculatordemo.client.CalcClient;
import com.example.calculatordemo.common.LoggerProxy;
import com.example.calculatordemo.math.Calculator;
import com.example.calculatordemo.math.CalculatorImpl;
import com.example.calculatordemo.math.CalculatorLogger;
import com.example.calculatordemo.math.CalculatorSecure;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class MyRunner implements CommandLineRunner {





    @Override
    public void run(final String... args) throws Exception {
        Calculator calculator = new CalculatorImpl();
        //calculator = new CalculatorLogger(calculator);
        calculator = (Calculator) LoggerProxy.newInstance(calculator);
        calculator = new CalculatorSecure(calculator);

        CalcClient client = new CalcClient(calculator);
        client.go();
    }
}
