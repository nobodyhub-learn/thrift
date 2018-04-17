package com.nobodyhub.learn.thrift.spring;

import com.nobodyhub.learn.thrift.spring.service.TCalculatiorService;
import com.nobodyhub.learn.thrift.spring.service.TDivisionByZeroException;
import com.nobodyhub.learn.thrift.spring.service.TOperation;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Ryan
 */
@Component
public class CalculatorServiceHandler implements TCalculatiorService.Iface {
    @Autowired
    protected CalculatorService calculatorService;

    @Override
    public int calculator(int num1, int num2, TOperation op) throws TException {
        switch (op) {
            case ADD: {
                return calculatorService.add(num1, num2);
            }
            case SUBTRACT: {
                return calculatorService.subtract(num1, num2);
            }
            case MULTIPLY: {
                return calculatorService.multiply(num1, num2);
            }
            case DIVIDE: {
                try {
                    return calculatorService.divide(num1, num2);
                } catch (IllegalArgumentException e) {
                    throw new TDivisionByZeroException();
                }
            }
            default: {
                throw new TException("Unknow Operation: " + op);
            }
        }
    }
}
