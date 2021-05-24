package com.rudra.calculator.operation;

import com.rudra.calculator.dto.Input;
import com.rudra.calculator.dto.Result;

/**
 * Operation class to perform various operation in the application.
 *
 * @author rudra
 */
public interface Operation {

    /**
     * Executes operation on the given input and returns result.
     *
     * @param input input on which operation needs to performed.
     * @return result of the operation.
     */
    Result perform(Input input);

}
