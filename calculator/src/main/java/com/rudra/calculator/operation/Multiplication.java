package com.rudra.calculator.operation;

import com.rudra.calculator.dto.Input;
import com.rudra.calculator.dto.Result;

/**
 * Class to perform Multiplication on the given input.
 *
 * @author rudra
 */
public class Multiplication implements Operation {

    public static Multiplication getMultiplication() {
        return new Multiplication();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Result perform(Input input) {
        return Result.builder().result(input.getValues().stream().reduce(1, Math::multiplyExact)).build();
    }

}
