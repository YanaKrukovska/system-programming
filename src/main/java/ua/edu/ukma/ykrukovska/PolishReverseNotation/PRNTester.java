package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import java.util.List;
import java.util.Queue;

public class PRNTester {

    public static void main(String[] args) {
        Splitter splitter = new Splitter();
        Converter converter = new Converter();
        PRNCalculator prnCalculator = new PRNCalculator();

        List<String> expression1 = splitter.splitLine("50/(2*5) + sin (45 + 45)");
        Queue<String> res1 = converter.convertInfixToRPN(expression1);
        System.out.println(res1);
        System.out.println(prnCalculator.calculate(res1));

        List<String> expression2 = splitter.splitLine("12 + 2*((3*4) + (10/5))");
        Queue<String> res2 = converter.convertInfixToRPN(expression2);
        System.out.println(res2);
        System.out.println(prnCalculator.calculate(res2));

        List<String> expression3 = splitter.splitLine("(2 + cos (15 - 15))^2");
        Queue<String> res3 = converter.convertInfixToRPN(expression3);
        System.out.println(res3);
        System.out.println(prnCalculator.calculate(res3));

    }
}
