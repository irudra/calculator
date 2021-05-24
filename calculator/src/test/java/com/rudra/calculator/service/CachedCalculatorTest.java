package com.rudra.calculator.service;

import static com.rudra.calculator.operation.Type.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rudra.calculator.TestApplicationContext;
import com.rudra.calculator.controller.CalculatorController;
import com.rudra.calculator.dto.Input;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { CalculatorController.class, TestApplicationContext.class, CachedCalculator.class })
@DirtiesContext
public class CachedCalculatorTest {

	@Autowired
	@Qualifier("cachedCalculator")
	private Calculator cachedCalculator;

	@MockBean(name = "defaultCalculator")
	private Calculator calculator;

	@Test
	public void testCachedCalculatorCallsDefaultOnlyFirstTimeIfInputIsSame() throws InterruptedException {
		cachedCalculator.calculate(new Input(add, 1, 2, 3));
		verify(calculator, times(1)).calculate(any());
		cachedCalculator.calculate(new Input(add, 1, 2, 3));
		// without caching it would have been 2 times
		verify(calculator, times(1)).calculate(any());
		cachedCalculator.calculate(new Input(add, 1, 2, 3));
		// without caching it would have been 2 times
		verify(calculator, times(1)).calculate(any());
	}

	@Test
	public void testCachedCalculatorCallsDefaultIfInputAreDifferentEachTime() throws InterruptedException {
		cachedCalculator.calculate(new Input(add, 2, 2, 3));
		verify(calculator, times(1)).calculate(any());
		cachedCalculator.calculate(new Input(add, 3, 2, 3));
		verify(calculator, times(2)).calculate(any());
		cachedCalculator.calculate(new Input(multiply, 2, 2, 3));
		verify(calculator, times(3)).calculate(any());
		cachedCalculator.calculate(new Input(subtract, 2, 2, 3));
		verify(calculator, times(4)).calculate(any());
	}

}
