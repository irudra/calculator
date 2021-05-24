package com.rudra.calculator.operation;

import com.rudra.calculator.dto.Input;
import com.rudra.calculator.dto.Result;

/**
 * Division operation class to perform division on the given input.
 *
 * @author rudra
 */
public class Division implements Operation {

    public static Division getDivision() {
        return new Division();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Result perform(Input input) {
        if (input.getValues().size() != 2) {
            return Result.builder().error("Exactly 2 argument are supported for Division Operation").isError(true).build();
        }

        if (input.getValues().get(1) == 0) {
            return Result.builder().error("Divisor can Not be zero").isError(true).build();
        }

        final int a = input.getValues().get(0);
        final int b = input.getValues().get(1);
        return Result.builder().result(a / b).build();
    }

}
