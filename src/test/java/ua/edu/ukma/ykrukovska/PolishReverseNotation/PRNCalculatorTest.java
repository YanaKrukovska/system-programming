package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class PRNCalculatorTest {

    @Test
    public void countSum() {
        PRNCalculator calculator = new PRNCalculator();
        List<String> expression = new LinkedList<>(Arrays.asList("1", "9", "10", "+", "+"));
        Assertions.assertEquals(20, calculator.calculate(expression));
    }

    @Test
    public void countSubtraction() {
        PRNCalculator calculator = new PRNCalculator();
        List<String> expression = new LinkedList<>(Arrays.asList("20", "19", "-", "1", "-"));
        Assertions.assertEquals(0, calculator.calculate(expression));
    }

    @Test
    public void countMultiplication() {
        PRNCalculator calculator = new PRNCalculator();
        List<String> expression = new LinkedList<>(Arrays.asList("5", "2", "3", "*", "*"));
        Assertions.assertEquals(30, calculator.calculate(expression));
    }

    @Test
    public void countMultiplicationWithZero() {
        PRNCalculator calculator = new PRNCalculator();
        List<String> expression = new LinkedList<>(Arrays.asList("0", "2", "3", "*", "*"));
        Assertions.assertEquals(0, calculator.calculate(expression));
    }

    @Test
    public void countDivision() {
        PRNCalculator calculator = new PRNCalculator();
        List<String> expression = new LinkedList<>(Arrays.asList("10", "5", "/", "1", "/"));
        Assertions.assertEquals(2, calculator.calculate(expression));
    }

}