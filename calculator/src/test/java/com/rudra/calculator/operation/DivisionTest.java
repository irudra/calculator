package com.rudra.calculator.operation;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.rudra.calculator.dto.Input;
import com.rudra.calculator.dto.Result;

@SpringBootTest
public class DivisionTest {

	private final Division division = Division.getDivision();

	@Test
	public void testResultFromDivisionHasErrorIfInputHasLessOrMoreThan2Arguments() throws InterruptedException {
		final Result result = division.perform(new Input(Type.division, 1));
		assertTrue(result.isError());
	}

	@Test
	public void testResultFromDivisionHasErrorIfInputHasSecondArgumentAsZero() throws InterruptedException {
		final Result result = division.perform(new Input(Type.division, 1, 0));
		assertTrue(result.isError());
	}

	@Test
	public void testResultFromDivisionHasValidResultIfInputHasTwoValidArgument() throws InterruptedException {
		Result result = division.perform(new Input(Type.division, 4, 2));
		assertFalse(result.isError());
		assertNull(result.getError());
		assertEquals((Integer) 2, result.getResult());

	}

}
