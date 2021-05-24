package com.rudra.calculator.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rudra.calculator.TestApplicationContext;
import com.rudra.calculator.controller.CalculatorController;
import com.rudra.calculator.dto.Result;
import com.rudra.calculator.operation.OperationProvider;
import com.rudra.calculator.service.CachedCalculator;
import com.rudra.calculator.service.DefaultCalculator;

/**
 * Integration test for testing all the modules are working as expected.
 * 
 * @author rudra
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = { CalculatorController.class,
		TestApplicationContext.class, CachedCalculator.class, DefaultCalculator.class, OperationProvider.class })
@DirtiesContext
public class CalculatorControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testWeAreGettingAddResultWhenURLHasAddInIt() {
		Result result = this.restTemplate.getForObject("/add/1/2/3", Result.class);
		Assert.assertTrue(result.getResult().equals(6));
	}

	@Test
	public void testWeAreGettingAddResultWhenURLHasAddInItWithTwoVariable() {
		Result result = this.restTemplate.getForObject("/add/1/2", Result.class);
		Assert.assertTrue(result.getResult().equals(1 + 2));
	}

	@Test
	public void testWeAreGettingAddResultWhenURLHasAddInItWithOneVariable() {
		Result result = this.restTemplate.getForObject("/add/1", Result.class);
		Assert.assertTrue(result.getResult().equals(1));
	}

	@Test
	public void testWeAreGettingMultiplyResultWhenURLHasMultiplyInIt() {
		Result result = this.restTemplate.getForObject("/multiply/2/2/3", Result.class);
		Assert.assertTrue(result.getResult().equals(2 * 2 * 3));
	}

	@Test
	public void testWeAreGettingMultiplyResultWhenURLHasMultiplyInItWithTwoVariable() {
		Result result = this.restTemplate.getForObject("/multiply/2/2", Result.class);
		Assert.assertTrue(result.getResult().equals(2 * 2));
	}

	@Test
	public void testWeAreGettingMultiplyResultWhenURLHasMultiplyInItWithOneVariable() {
		Result result = this.restTemplate.getForObject("/multiply/2", Result.class);
		Assert.assertTrue(result.getResult().equals(2));
	}

	@Test
	public void testWeAreGettingSubstractResultWhenURLHasSubtractInIt() {
		Result result = this.restTemplate.getForObject("/subtract/5/2/3", Result.class);
		Assert.assertTrue(result.getResult().equals(5 - 2 - 3));
	}

	@Test
	public void testWeAreGettingSubstractResultWhenURLHasSubtractInItWithTwoVariable() {
		Result result = this.restTemplate.getForObject("/subtract/5/2", Result.class);
		Assert.assertTrue(result.getResult().equals(5 - 2));
	}

	@Test
	public void testWeAreGettingSubstractResultWhenURLHasSubtractInItWithOneVariable() {
		Result result = this.restTemplate.getForObject("/subtract/5", Result.class);
		Assert.assertTrue(result.getResult().equals(5));
	}

	@Test
	public void testWeAreGettingDivideResultWhenURLHasDivideInIt() {
		Result result = this.restTemplate.getForObject("/division/5/2", Result.class);
		Assert.assertTrue(result.getResult().equals(5 / 2));
	}

}
