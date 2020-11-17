package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PRNCalculatorTest {

    @Test
    public void countSum() {
        PRNCalculator calculator = new PRNCalculator();
        Queue<String> expression = new LinkedList<>(Arrays.asList("1", "9", "10", "+", "+"));
        assertEquals(20, calculator.calculate(expression));
    }

    @Test
    public void countSubtraction() {
        PRNCalculator calculator = new PRNCalculator();
        Queue<String> expression = new LinkedList<>(Arrays.asList("20", "19", "-", "1", "-"));
        assertEquals(0, calculator.calculate(expression));
    }

    @Test
    public void countMultiplication() {
        PRNCalculator calculator = new PRNCalculator();
        Queue<String> expression = new LinkedList<>(Arrays.asList("5", "2", "3", "*", "*"));
        assertEquals(30, calculator.calculate(expression));
    }

    @Test
    public void countMultiplicationWithZero() {
        PRNCalculator calculator = new PRNCalculator();
        Queue<String> expression = new LinkedList<>(Arrays.asList("0", "2", "3", "*", "*"));
        assertEquals(0, calculator.calculate(expression));
    }

    @Test
    public void countDivision() {
        PRNCalculator calculator = new PRNCalculator();
        Queue<String> expression = new LinkedList<>(Arrays.asList("10", "5", "/", "1", "/"));
        assertEquals(2, calculator.calculate(expression));
    }

    @Test
    public void countSin() {
        Converter converter = new Converter();
        Splitter splitter = new Splitter();
        PRNCalculator calculator = new PRNCalculator();
        assertEquals(0, calculator.calculate(converter.convertInfixToRPN(splitter.splitLine("sin (15 - 15)"))));
    }

}