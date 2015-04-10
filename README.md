A reverse polish notation evaluator in java

In the language of your choice, please create a calculator capable of processing Reverse Polish Notation with the following rules:

	1. It can parse variable sized reverse polish notation inputs
	2. It can perform the 4 basic operators (addition, subtraction, multiplication, division)
	3. It will spit back the result of the input
	4. It can handle malformed RPN strings
	5. It should include unit tests
	6. Use this as an opportunity to show off your talents in structure code and your knowledge of data structures
	7. Please provide instructions to run the application

Example: (2 3 + 5 + 10 -) = 0 (2 2 2 * * 3 +) = 11

Assumptions:
	
	1. We deal only with binary operators (=, - , *, /)
	2. The result fits into a java Double
	3. The evaluator throws custom exceptions when it finds a problem with the expression
	
Instructions to run:

	1. Download the code and import the project into eclipse or any java ide.
	2. Add the commons-lang3-3.4.jar if not available. This is where we source StringUtils from
	3. Add Junit4 libraries
	4. Run all the unit tests in the ide
	5. One can also run the main method RpnEvaluatorMain.java 

Algorithm:

	1. If the expression is empty, throw an exception as there is nothing to evaluate
	2. Normalize the input string to remove any additional whitespace and paranthesis. The reverse polish notation does not 	consider brackets.  
	3. Tokenize the expression
	4. Run through all the tokens:
			if the token is a number, push onto a stack
			if the token is an operator pop the top 2 elements, apply the operator and push the result onto the stack.
			it's an error otherwise, handle accordingly
	5. Once we run out of tokens, check the stack. If the stack has exactly one value then we have our answer, else its an error.

Improvements:

1. We can enhance the evaluator to accept unary operators.
	

