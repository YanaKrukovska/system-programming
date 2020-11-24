package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import java.util.List;
import java.util.Stack;

public class PRNCalculator {

    public double calculate(List<String> expressions) {
        Stack<Double> stack = new Stack();
        double operand1;
        double operand2;
        int stepCounter = 0;
        for (String exp : expressions) {
            if (isNumber(exp)) {
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
                    case '^':
                        operand1 = stack.pop();
                        operand2 = stack.pop();
                        stack.push(Math.pow(operand2, operand1));
                }
            } else if (exp.length() == 3) {
                double degreesToRadians = Math.toRadians(stack.pop());
                switch (exp) {
                    case "sin":
                        stack.push(Math.sin(degreesToRadians));
                        break;
                    case "cos":
                        stack.push(Math.cos(degreesToRadians));
                        break;
                    case "tan":
                        stack.push(Math.tan(degreesToRadians));
                        break;
                    case "ctg":
                        stack.push(1.0 / Math.tan(degreesToRadians));
                        break;
                }
            }
            System.out.println(stepCounter++ + ". current = " + exp + ", stack = " + stack.toString());
        }
        return stack.peek();
    }

    private boolean isNumber(String exp) {
        return exp.matches("-?[0-9.]+");
    }

}
