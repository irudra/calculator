package com.rudra.calculator.operation;

import com.rudra.calculator.dto.Input;
import com.rudra.calculator.dto.Result;

/**
 * Operation to perform addition of a given input.
 *
 * @author rudra
 */
public class Addition implements Operation {

    public static Addition getAddition() {
        return new Addition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Result perform(Input input) {
        return Result.builder().result(input.getValues().stream().reduce(0, Integer::sum)).build();

    }

}
