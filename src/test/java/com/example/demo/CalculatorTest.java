package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	Calculator calculator;
	
	@BeforeEach
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test
	public void testMultiply() {
		assertEquals(200, calculator.multiply(10, 20));
		assertEquals(10, calculator.multiply(5, 5));
	}
	
	@Test
	public void testDivide() {
		assertEquals(2, calculator.divide(4, 2));
	}

}
