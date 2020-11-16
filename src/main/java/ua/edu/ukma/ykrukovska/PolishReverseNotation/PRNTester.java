package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import java.util.List;

public class PRNTester {

    public static void main(String[] args) {
        Splitter splitter = new Splitter();
        Converter converter = new Converter();
        PRNCalculator prnCalculator = new PRNCalculator();
        List<String> split = splitter.splitLine("x^y / (5 * z) + 10");
        System.out.println(converter.convertInfixToRPN(split));

        List<String> split1 = splitter.splitLine("(3+4)*(5–2)");
        System.out.println(prnCalculator.calculate(splitter.splitLine("1 2 + 3 4 + *")));
    }
}
