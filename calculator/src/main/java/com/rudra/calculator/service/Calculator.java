package com.rudra.calculator.service;

import com.rudra.calculator.dto.Input;
import com.rudra.calculator.dto.Result;

/**
 * Calculator to calculate some operation based on the type of the input.
 * 
 * @author rudra
 *
 */
public interface Calculator {

	/**
	 * Performs operation on the input and provide results based on type of the
	 * input
	 * 
	 * @param input
	 *            value on which we need to perform operation.
	 * @return result of the operation.
	 */
	Result calculate(Input input);

}
