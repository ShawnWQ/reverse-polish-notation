package com.nitin.handy.challenge.rpn;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.nitin.handy.challenge.rpn.exceptions.EmptyExpressionException;
import com.nitin.handy.challenge.rpn.exceptions.InvalidTokensException;
import com.nitin.handy.challenge.rpn.exceptions.TooFewOperandsException;
import com.nitin.handy.challenge.rpn.exceptions.TooFewOperatorsException;
import com.nitin.handy.challenge.rpn.operators.AdditionOperator;
import com.nitin.handy.challenge.rpn.operators.DivisionOperator;
import com.nitin.handy.challenge.rpn.operators.MultiplicationOperator;
import com.nitin.handy.challenge.rpn.operators.RpnOperator;
import com.nitin.handy.challenge.rpn.operators.SubtractionOperator;


/**
 * The RpnEvaluator class provides the ability to evaluate Reverse Polish notion expression.
 * 
 * It works on Double types
 * 
 * @author nitin
 *
 */
public class RpnEvaluator {
	
	private final Map<String, RpnOperator> operatorMap;
	
	public RpnEvaluator() {
		operatorMap = new HashMap<>();
		operatorMap.put("+", new AdditionOperator());
		operatorMap.put("-", new SubtractionOperator());
		operatorMap.put("*", new MultiplicationOperator());
		operatorMap.put("/", new DivisionOperator());
	}
	
	/**
	 * Evaluates a single Reverse Polish Notation
	 * 
	 * 
	 * @param expression
	 * @return
	 * @throws EmptyExpressionException
	 */
	public Double evaluate(String expression) throws Exception {
		if(StringUtils.isBlank(expression))
			throw new EmptyExpressionException();
		
		/** The stack used to store the operands **/
		Deque<Double> stack = new LinkedList<Double>();
		
		/** Split the expression into tokens after normalization **/
		List<String> tokens = normalizeAndTokenize(expression);
		
		
		for(String token : tokens) {

			/** If we find a numeric token, push it onto the stack **/
			if(StringUtils.isNumeric(token)) {
				stack.push(new Double(token));
			}
			
			/** We are dealing only with binary operators. 
			 * Check that the stack has atleast 2 elements
			 * Apply the operator by popping the top 2 elements
			 * Push the result on to the top of the stack
			 * **/
			else if(isOperator(token)) {
				if(stack.size() < 2)
					throw new TooFewOperandsException();
				
				Double result = operatorMap.get(token).apply(stack);
				stack.push(result);		
			}
			
			else {
				throw new InvalidTokensException();
			}
				
		}
		
		/**Stack should never be empty unless it's corrupt **/
		if(stack.size() > 1 || stack.isEmpty()) {
			throw new TooFewOperatorsException();
		}
		
		return stack.pop();
	}

	/**
	 * Checks if the current token is an operator
	 * @param token
	 * @return
	 */
	private boolean isOperator(String token) {
		return operatorMap.containsKey(token);
	}

	/**
	 * Normalizes the String by removing all trailing and leading spaces and by
	 * replacing all multi length whitespace with a single whitespace
	 * 
	 * Removes all parenthesis as the Reverse polish notation doesn't support them
	 * 
	 * Tokenizes the String after normalization
	 * @param str
	 * @return
	 */
	private List<String> normalizeAndTokenize(String str) {
		
		String normalized = str;
		normalized = StringUtils.normalizeSpace(normalized);
		
		normalized = StringUtils.remove(normalized, '(');
		normalized = StringUtils.remove(normalized, ')');
		
		List<String> tokens = Arrays.asList(StringUtils.split(normalized));
		
		return tokens;
	}
}
