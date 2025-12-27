package A5_PostfixEvaluation_Stack;

import java.util.Scanner;

public class Stack {

	int max_size;
	int[] stk;
	int top;

	public Stack(int n) {
		max_size = n;
		top = -1;
		stk = new int[n];
	}

	public Stack() {

	}

	public boolean isFull() {
		return top == max_size - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int element) {
		if (isFull()) {
			System.out.println("Stack Overflow!");
		} else {
			stk[++top] = element;
		}
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow!");
			return -1;
		} else {
			return stk[top--];
		}
	}

	public void postfix() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter postfix expression (e.g., 23*52*1+9-): ");
		String exp = sc.nextLine();
		top = -1;

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (Character.isDigit(ch)) {
				push(Character.getNumericValue(ch));
			} else {
				int val2 = pop();
				int val1 = pop();
				int result = 0;

				switch (ch) {
				case '+':
					result = val1 + val2;
					break;
				case '-':
					result = val1 - val2;
					break;
				case '*':
					result = val1 * val2;
					break;
				case '/':
					if (val2 == 0) {
						System.out.println("Error: Division by zero");
						return;
					}
					result = val1 / val2;
					break;
				default:
					System.out.println("Invalid character in expression: " + ch);
					return;
				}
				push(result);
			}
		}
		System.out.println("Result: " + pop());
	}

	public void reverse() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string to reverse: ");
		String str = sc.nextLine();
		int len = str.length();

		char[] charStack = new char[len];
		int charTop = -1;

		for (int i = 0; i < len; i++) {
			charTop++;
			charStack[charTop] = str.charAt(i);
		}

		System.out.print("Reversed string: ");
		while (charTop >= 0) {
			System.out.print(charStack[charTop]);
			charTop--;
		}
	}

}
