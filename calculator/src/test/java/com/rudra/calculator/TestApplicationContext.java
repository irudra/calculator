package com.rudra.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@EnableCaching
@EnableAutoConfiguration
@DirtiesContext
@SpringBootTest
public class TestApplicationContext {

	@Test
	void contextLoads() {
	}

}