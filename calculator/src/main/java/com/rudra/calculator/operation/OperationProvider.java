package com.rudra.calculator.operation;

import org.springframework.stereotype.Component;

/**
 * Operation provider to provider different strategy for different kind of
 * operation.
 *
 * @author rudra
 */
@Component
public class OperationProvider {

    /**
     * Returns a specific operation based on the supplied type.
     *
     * @param type type of the operation required.
     * @return Operation instance of the given type.
     */
    public Operation getOperation(final Type type) {
        switch (type) {
            case add:
                return Addition.getAddition();
            case multiply:
                return Multiplication.getMultiplication();
            case subtract:
                return Subtraction.getSubtraction();
            case division:
                return Division.getDivision();
        }
        throw new IllegalArgumentException("The Supplied operation is not supported : " + type);
    }

}
