package com.rudra.calculator.operation;

import com.rudra.calculator.dto.Input;
import com.rudra.calculator.dto.Result;

/**
 * Class to perform Subtraction of the input.
 *
 * @author rudra
 */
public class Subtraction implements Operation {

    public static Subtraction getSubtraction() {
        return new Subtraction();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Result perform(final Input input) {
        final int num = input.getValues().get(0);
        return Result.builder().result(input.getValues().stream().skip(1).reduce(num, Math::subtractExact)).build();
    }

}
