/**
 * 
 * @author Camron Franklin CMSC204 CRN 36096
 *
 */
public class Notation {

	
	
	/**
	 * evaluates valid postfix expression, returns double of result
	 * @param intermediatePostfix - expression to be evaluated
	 * @return double value of evaluated expression
	 * @throws InvalidNotationFormatException if Stack Over/Underflow exceptions are caught
	 */
	@SuppressWarnings("unused")
	public static double evaluatePostfixExpression(String intermediatePostfix) throws InvalidNotationFormatException {
		double result = 0;
		MyStack<Double> stack = new MyStack<Double>(10);
		
		for (int i = 0; i < intermediatePostfix.length(); i++) {
			String current = Character.toString(intermediatePostfix.charAt(i));
			
			if ("0123456789".contains(current)) {
				try {
				stack.push(Double.parseDouble(current));
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
				continue;
			}
			if ("+-*/".contains(current)) {
				Double op2;
				Double op1;
				try {
					op2 = stack.pop();
					op1 = stack.pop();
				} catch (StackUnderflowException e) {
					throw new InvalidNotationFormatException();
				}
				
				switch(current) {
				case "+":
					try{
						stack.push(op1 + op2);
					} catch (StackOverflowException e) {
						throw new InvalidNotationFormatException();
					}
					break;
				case "-":
					try {
					stack.push(op1 - op2);
					} catch (StackOverflowException e) {
						throw new InvalidNotationFormatException();
					}
					break;
				case "*":
					try {
					stack.push(op1 * op2);
					} catch (StackOverflowException e) {
						throw new InvalidNotationFormatException();
					}
					break;
				case "/":
					try{
						stack.push(op1 / op2);
					} catch (StackOverflowException e) {
						throw new InvalidNotationFormatException();
					}
					break;
				}
			}
		}
		if (stack.size() > 1)
			throw new InvalidNotationFormatException();
		return stack.pop();
	}

	/**
	 * Converts valid infix expression to postfix form
	 * @param complexInfix - expression to be converted
	 * @return String form of postfix expression
	 * @throws InvalidNotationFormatException if Stack/Queue Over/Underflow exception is caught
	 */
	public static String convertInfixToPostfix(String complexInfix) throws InvalidNotationFormatException {
		MyStack<String> stack = new MyStack<String>(20);
		MyQueue<String> queue = new MyQueue<String>(20);
		String postfix = "";
		try {
			
			for (int i = 0; i < complexInfix.length(); i++) {
				String current = Character.toString(complexInfix.charAt(i));
				if("0123456789".contains(current)) {
					try{
						queue.enqueue(current);
					} catch (QueueOverflowException e) {
						throw new InvalidNotationFormatException();
					}
					continue;
				}
				if ("(".equals(current)) {
					try {
						stack.push(current);
					} catch (StackOverflowException e) {
						throw new InvalidNotationFormatException();
					}
					continue;
				}
				if (")".equals(current)) {
					while (!stack.top().equals("("))
						try{
							queue.enqueue(stack.pop());
						} catch (StackUnderflowException e) {
							throw new InvalidNotationFormatException();
						} catch (QueueOverflowException e) {
							throw new InvalidNotationFormatException();
						}
					stack.pop();
					continue;
				}
				if ("+-/*".contains(current)) {
					if (stack.isEmpty() || stack.top().equals("(")) {
						try {
							stack.push(current);
						} catch (StackOverflowException e) {
							throw new InvalidNotationFormatException();
						}
						continue;
					} else {
						switch(current) {
						case "+":
						case "-":
							while(!stack.isEmpty()) {
								if ("+-/*".contains(stack.top())) {
									try{
										queue.enqueue(stack.pop());
									} catch (QueueOverflowException e) {
										throw new InvalidNotationFormatException();
									}
								}
								else
									break;
							}
							stack.push(current);
							break;
						case "*":
						case "/":
							while(!stack.isEmpty()) {
								if ("/*".contains(stack.top())) {
									try{
										queue.enqueue(stack.pop());
									} catch (QueueOverflowException e) {
										throw new InvalidNotationFormatException();
									}
								}
								else
									break;
							}
							stack.push(current);
							break;
						}
					continue;
				}
			}
		}
			while (!stack.isEmpty())
				queue.enqueue(stack.pop());
		} catch (Exception e) {
			throw new InvalidNotationFormatException();
		}
		postfix = queue.toString();
		return postfix;
	}

	
	/**
	 * Converts postfix expression into infix expression
	 * @param easyPostfix expression to be converted
	 * @return string representation of infix expression
	 * @throws InvalidNotationFormatException if Stack Over/Underflow exception is caught
	 */
	public static String convertPostfixToInfix(String easyPostfix) throws InvalidNotationFormatException {
		MyStack<String> stack = new MyStack<String>(10);
		for (int i = 0; i < easyPostfix.length(); i++) {
			String current = Character.toString(easyPostfix.charAt(i));
			
			if ("0123456789".contains(current)) {
				try{
					stack.push(current);
				} catch (StackOverflowException e) {
					throw new InvalidNotationFormatException();
				}
			}
			if ("+-*/".contains(current)) {
				String temp;
				try {
					String s1 = stack.pop();
					String s2 = stack.pop();
					temp = "(" + s2 + current + s1 + ")";
				} catch (StackUnderflowException e) {
					throw new InvalidNotationFormatException();
				}
				stack.push(temp);
			}
		}
		if (stack.size() > 1)
			throw new InvalidNotationFormatException();
		return stack.pop();
	}
}
