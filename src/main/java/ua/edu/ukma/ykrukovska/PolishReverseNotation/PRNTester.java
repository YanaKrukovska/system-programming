package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import java.util.List;

public class PRNTester {

    public static void main(String[] args) {
        Converter converter = new Converter();
        PRNCalculator prnCalculator = new PRNCalculator();

        String expression1String = "50/(2*5) + sin (45 + 45)";
        List<String> expression1 = Splitter.splitLine(expression1String);
        List<String> res1 = converter.convertInfixToRPN(expression1);
        System.out.println("Original: " + expression1String + ", converted: " + converter.convertToString(res1));
        System.out.println("Result: " + prnCalculator.calculate(res1));
        System.out.println();

        String expression2String = "12 + 2*((3*4) + (10/5))";
        List<String> expression2 = Splitter.splitLine(expression2String);
        List<String> res2 = converter.convertInfixToRPN(expression2);
        System.out.println("Original: " + expression2String + ", converted: " + converter.convertToString(res2));
        System.out.println("Result: " + prnCalculator.calculate(res2));
        System.out.println();

        String expression3String = "A = M[i, j + 1, k]";
        List<String> expression3 = Splitter.splitLine(expression3String);
        List<String> res3 = converter.convertInfixToRPN(expression3);
        System.out.println("Original: " + expression3String + ", converted: " + converter.convertToString(res3));

    }
}
