package com.nitin.handy.challenge.rpn;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.nitin.handy.challenge.rpn.exceptions.DivideByZeroException;
import com.nitin.handy.challenge.rpn.exceptions.EmptyExpressionException;
import com.nitin.handy.challenge.rpn.exceptions.InvalidTokensException;
import com.nitin.handy.challenge.rpn.exceptions.TooFewOperandsException;
import com.nitin.handy.challenge.rpn.exceptions.TooFewOperatorsException;

/**
 * Unit tests for RpnEvaluator
 * @author nitin
 *
 */
public class RpnEvaluatorTest {
	
	private RpnEvaluator evaluator;
	
	@Before
	public void setUp() {
		evaluator = new RpnEvaluator();
	}
	
	@After
	public void tearDown() {
		evaluator = null;
	}
	
	@Test(expected = EmptyExpressionException.class)
	public void testShouldThrowExceptionWhenExprIsEmpty() throws Exception {
		evaluator.evaluate(null);
	}

	@Test(expected = DivideByZeroException.class)
	public void testShouldThrowExceptionOnDivByZero() throws Exception {
		evaluator.evaluate("1      0    /");
	}
	
	@Test(expected = TooFewOperandsException.class)
	public void testShouldThrowExceptionTooFewOperands() throws Exception {
		evaluator.evaluate("1 2  /      +");
	}
	
	@Test(expected = TooFewOperatorsException.class)
	public void testShouldThrowExceptionTooFewOperators() throws Exception {
		evaluator.evaluate("1 2  ");
	}
	
	@Test(expected = InvalidTokensException.class)
	public void testShouldThrowExceptionInvalidTokens() throws Exception {
		evaluator.evaluate("1 a  ");
	}
	
	@Test
	public void testSingleOperationWithStrayWhiteSpace() throws Exception {
		assertEquals(new Double(5), evaluator.evaluate("2      3       +"));
	}
	
	@Test
	public void testShouldHandleMultiLengthTokens() throws Exception {
		assertEquals(new Double(-10), evaluator.evaluate("5 2 *  10 2 * -"));
	}
	
	
	@Test
	public void testEvaluatesWellFormedExpr1() throws Exception {
		assertEquals(new Double(0), evaluator.evaluate(" (2 3 + 5 + 10 -)"));
	}
	
	@Test
	public void testEvaluatesWellFormedExpr2() throws Exception {
		assertEquals(new Double(11), evaluator.evaluate("(2 2 2 * * 3 +) "));
	}

}
