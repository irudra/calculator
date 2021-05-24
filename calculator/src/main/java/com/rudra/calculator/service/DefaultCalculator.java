package com.rudra.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rudra.calculator.dto.Input;
import com.rudra.calculator.dto.Result;
import com.rudra.calculator.operation.OperationProvider;

/**
 * Default calculator for calculating some operation on the input. This
 * calculator always perform operation on the input and calculates a new result
 * every time.
 * 
 * @author rudra
 *
 */
@Component("defaultCalculator")
public class DefaultCalculator implements Calculator {

	private final OperationProvider operationProvider;

	@Autowired
	DefaultCalculator(final OperationProvider operationProvider){
		this.operationProvider = operationProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Result calculate(final Input input) {
		return operationProvider.getOperation(input.getType()).perform(input);
	}

}
