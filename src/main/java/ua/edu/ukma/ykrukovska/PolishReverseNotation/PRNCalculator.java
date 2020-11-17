package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import java.util.Queue;
import java.util.Stack;

public class PRNCalculator {

    public double calculate(Queue<String> expressions) {
        Stack<Double> stack = new Stack();
        double operand1;
        double operand2;

        for (String exp : expressions) {
            if (isNumber(exp)){
                stack.push(Double.parseDouble(exp));
            } else if (exp.length() == 1) {
                switch (exp.charAt(0)) {
                    case '+':
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case '-':
                        operand2 = stack.pop();
                        operand1 = stack.pop();
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        operand2 = stack.pop();
                        operand1 = stack.pop();
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        operand2 = stack.pop();
                        operand1 = stack.pop();
                        stack.push(operand1 / operand2);
                        break;
                }
            } else if (exp.length() == 3) {
                switch (exp) {
                    case "sin":
                        stack.push(Math.sin(stack.pop()));
                        break;
                    case "cos":
                        stack.push(Math.cos(stack.pop()));
                        break;
                    case "tan":
                        stack.push(Math.tan(stack.pop()));
                        break;
                    case "ctg":
                        stack.push(1.0 / Math.tan(stack.pop()));
                        break;
                }
            }
        }
        return stack.peek();

    }

    private boolean isNumber(String exp) {
        return exp.matches("-?[0-9.]+");
    }

}
