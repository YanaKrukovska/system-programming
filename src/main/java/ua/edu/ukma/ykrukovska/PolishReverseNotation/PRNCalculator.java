package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import java.util.List;
import java.util.Stack;

public class PRNCalculator {

    public double calculate(List<String> expressions) {
        Stack<Double> stack = new Stack();
        boolean isNumber;
        double operand1;
        double operand2;
        double result = 0.0;

        for (String exp : expressions) {
            isNumber = true;
            if (exp.length() == 1) {
                isNumber = false;
                switch (exp.charAt(0)) {
                    case '+':
                        result = stack.pop() + stack.pop();
                        stack.push(result);
                        break;
                    case '-':
                        operand2 = stack.pop();
                        operand1 = stack.pop();
                        result = operand1 - operand2;
                        stack.push(result);
                        break;
                    case '*':
                        operand2 = stack.pop();
                        operand1 = stack.pop();
                        result = operand1 * operand2;
                        stack.push(result);
                        break;
                    case '/':
                        operand2 = stack.pop();
                        operand1 = stack.pop();
                        result = operand1 / operand2;
                        stack.push(result);
                        break;
                    default:
                        isNumber = true;
                }
            }
            if (isNumber) {
                stack.push(Double.parseDouble(exp));
            }
        }
        return result;

    }

}
