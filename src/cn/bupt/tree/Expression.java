package cn.bupt.tree;

import java.util.Stack;

public class Expression {
	
	public static void main(String[] args) {
		char c[]={'(','a','+','b','*','c',')','+','(','(','d','*','e','+','f',')','*','g',')'};
		System.out.println(getSubExpression(c));

	}
	
	public static int getPriority(char c){
		switch (c) {
		case '+':
		case '-':
			return 0;
		case '(':
		case ')':
			return -1;
		default:
			return 1;
		}
	}
	
	public static String getSubExpression(char c[]){
		String expression="";
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<c.length;i++){
			switch (c[i]) {
			case '+':
			case '-':
			case '*':
			case '/':
				while(!stack.isEmpty()&&getPriority(stack.peek())>=getPriority(c[i])){
					expression+=stack.pop();
				}
				stack.push(c[i]);
				break;
			case '(':
				stack.push('(');
				break;
			case ')':
				while(!stack.isEmpty()&&stack.peek()!='('){
					expression+=stack.pop();
				}
				stack.pop();
				break;
			default:
				expression+=c[i];
				break;
			}
		}
		return expression;
	}

}
