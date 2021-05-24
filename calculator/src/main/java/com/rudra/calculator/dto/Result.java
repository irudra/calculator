package com.rudra.calculator.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * Result class which represents the outcome of the operation.
 *
 * @author rudra
 */
@Getter
@Builder
public class Result {

    private Integer result;

    private boolean isError = false;
    private String error;
}
