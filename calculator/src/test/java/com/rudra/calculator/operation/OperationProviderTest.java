package com.rudra.calculator.operation;

import static com.rudra.calculator.operation.Type.add;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext
public class OperationProviderTest {

	@Autowired
	private OperationProvider operationProvider;

	@Test
	public void testOperationProviderReturnsOperationIfAValidArgumentIsSupplied() throws InterruptedException {
		assertNotNull(operationProvider.getOperation(add));
	}

}
