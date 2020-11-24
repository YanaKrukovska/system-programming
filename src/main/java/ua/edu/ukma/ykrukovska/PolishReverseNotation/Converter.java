package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import java.util.*;

public class Converter {

    public static final Map<String, Integer> precedence;

    public List<String> convertInfixToRPN(List<String> infixNotation) {
        List<String> result = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        for (String token : infixNotation) {
            if ("(".equals(token)) {
                stack.push(token);
                continue;
            }

            if (")".equals(token)) {
                while (!"(".equals(stack.peek())) {
                    result.add(stack.pop());
                }
                stack.pop();
                continue;
            }

            if (precedence.containsKey(token)) {
                while (!stack.empty() && precedence.get(token) <= precedence.get(stack.peek())) {
                    result.add(stack.pop());
                }
                stack.push(token);
                continue;
            }
            result.add(token);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public String convertToString(List<String> elements) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String element : elements) {
            stringBuilder.append(element).append(" ");
        }

        return stringBuilder.toString();
    }

    static {
        Map<String, Integer> temp = new HashMap<>();
        temp.put("sin", 5);
        temp.put("cos", 5);
        temp.put("tan", 5);
        temp.put("ctg", 5);
        temp.put("^", 4);
        temp.put("/", 3);
        temp.put("*", 3);
        temp.put("+", 2);
        temp.put("-", 2);
        temp.put(")", 1);
        temp.put("(", 0);
        precedence = Collections.unmodifiableMap(temp);
    }

}
