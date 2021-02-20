/** 
 * Converts infix expressions to postfix expressions and vice versa, and
 * evaluates postfix expressions all using stacks and queues
 * @author Rowan Barr
 */
public class Notation {


	/**
	 * converts an infix expression to a postfix expression
	 * @param infix an infix expression in string format
	 * @return a postfix expression in string format
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException, QueueOverflowException, StackOverflowException, StackUnderflowException {
		NotationQueue postfixQueue = new NotationQueue();
		NotationStack postfixStack = new NotationStack();
		for (int i = 0; i < infix.length(); i++) {
			if (infix.charAt(i)==' ')
			{
				continue;
			}
			if (infix.charAt(i)>47&&infix.charAt(i)<58)
			{
				postfixQueue.enqueue(infix.charAt(i));
			}
			if (infix.charAt(i) == '(')
			{
				postfixStack.push(infix.charAt(i));
			}
			if (infix.charAt(i) == 42||infix.charAt(i) == 43||infix.charAt(i) == 45||infix.charAt(i) == 47)
			{
				if (postfixStack.size()>0) 
				{
					while(!postfixStack.top().equals('('))
					{
						postfixQueue.enqueue(postfixStack.pop());
					}
				}
				postfixStack.push(infix.charAt(i));
			}
			if (infix.charAt(i) == ')')
			{
				while(!postfixStack.top().equals('('))
				{
					postfixQueue.enqueue(postfixStack.pop());
					if (postfixStack.size()==0)
					{
						throw new InvalidNotationFormatException("There is a missing left parenthesis!");
					}
				}
				postfixStack.pop();
			}
		}
		while (postfixStack.size()>0) 
		{
			postfixQueue.enqueue(postfixStack.pop());
		}
		return postfixQueue.toString();
	}
	/**
	 * converts an postfix expression to a infix expression
	 * @param postfix a postfix expression in string format
	 * @return an infix expression in string format
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException, StackOverflowException, StackUnderflowException {
		NotationStack infixStack = new NotationStack();
		String s = "";
		Object a = "";
		Object b = "";
		for (int i = 0; i < postfix.length(); i++) {
			if (postfix.charAt(i)==' ')
			{
				continue;
			}
			if (postfix.charAt(i)>47&&postfix.charAt(i)<58)
			{
				infixStack.push(postfix.charAt(i));
			}
			if (postfix.charAt(i) == 42||postfix.charAt(i) == 43||postfix.charAt(i) == 45||postfix.charAt(i) == 47)
			{
				if (infixStack.size()>1) 
				{
					a = infixStack.pop();
					b = infixStack.pop();
					s = "(" + b + postfix.charAt(i) + a + ")";
					infixStack.push(s);
				}
				else
				{
					throw new InvalidNotationFormatException("Invalid postfix expression!");
				}
			}
		}
		while (infixStack.size()>1) 
		{
			throw new InvalidNotationFormatException("Invalid postfix expression!");
		}
		return infixStack.toString();
	}
	/**
	 * evaluates a postfix expression
	 * @param postfix a postfix expression in string format
	 * @return a double that's equal to the postfix string
	 */
	public static double evaluatePostfixExpression(String postfix) throws InvalidNotationFormatException, StackUnderflowException, StackOverflowException {
		NotationStack  infixStack = new NotationStack();
		double d;
		double a;
		double b;
		for (int i = 0; i < postfix.length(); i++) {
			if (postfix.charAt(i)==' ')
			{
				continue;
			}
			if (postfix.charAt(i)>47&&postfix.charAt(i)<58)
			{
				d = (postfix.charAt(i)) - 48;
				infixStack.push(d);
			}
			if (postfix.charAt(i) == 42)
			{
				if (infixStack.size()>1) 
				{
					a = (double) infixStack.pop();
					b = (double) infixStack.pop();
					d = b * a;
					infixStack.push(d);
				}
				else
				{
					throw new InvalidNotationFormatException("Invalid postfix expression!");
				}
			}
			if (postfix.charAt(i) == 43)
			{
				if (infixStack.size()>1) 
				{
					a = (double) infixStack.pop();
					b = (double) infixStack.pop();
					d = b + a;
					infixStack.push(d);
				}
				else
				{
					throw new InvalidNotationFormatException("Invalid postfix expression!");
				}
			}
			if (postfix.charAt(i) == 45)
			{
				if (infixStack.size()>1) 
				{
					a = (double) infixStack.pop();
					b = (double) infixStack.pop();
					d = b - a;
					infixStack.push(d);
				}
				else
				{
					throw new InvalidNotationFormatException("Invalid postfix expression!");
				}
			}
			if (postfix.charAt(i) == 47)
			{
				if (infixStack.size()>1) 
				{
					a = (double) infixStack.pop();
					b = (double) infixStack.pop();;
					d = b / a;
					infixStack.push(d);
				}
				else
				{
					throw new InvalidNotationFormatException("Invalid postfix expression!");
				}
			}
		}
		while (infixStack.size()>1) 
		{
			throw new InvalidNotationFormatException("Invalid postfix expression!");
		}
		a = (double) infixStack.pop();
		return a;
	}

}
