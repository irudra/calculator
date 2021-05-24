package com.rudra.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.rudra.calculator.dto.Input;
import com.rudra.calculator.dto.Result;

/**
 * A decorator on the Actual calculator to check if the input is already
 * calculated the calculation is not performed again.
 *
 * @author rudra
 */
@Component("cachedCalculator")
public class CachedCalculator implements Calculator {

    private final Calculator calculator;

    @Autowired
    CachedCalculator(@Qualifier("defaultCalculator") final Calculator calculator) {
        this.calculator = calculator;
    }

    /**
     * {@inheritDoc}
     */
    @Cacheable(value = "inputs", key = "#input")
    @Override
    public Result calculate(final Input input) {
        return calculator.calculate(input);
    }

}
