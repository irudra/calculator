package com.rudra.calculator.dto;

import com.rudra.calculator.operation.Type;
import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Input class for various operation.
 *
 * @author rudra
 */
@Data
public class Input {

    private Type type;

    private List<Integer> values;

    public Input(Type type, Integer... values) {
        this.type = type;
        this.values = Arrays.asList(values);
    }

    public Input(Type type, List<Integer> values) {
        this.type = type;
        this.values = values;
    }
}
