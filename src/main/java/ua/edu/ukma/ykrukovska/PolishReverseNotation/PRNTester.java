package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import java.util.List;
import java.util.Queue;

public class PRNTester {

    public static void main(String[] args) {
        Splitter splitter = new Splitter();
        Converter converter = new Converter();
        PRNCalculator prnCalculator = new PRNCalculator();

        List<String> split = splitter.splitLine("sin (15 - 15)");
        Queue<String> res = converter.convertInfixToRPN(split);
        System.out.println(res);
        System.out.println(prnCalculator.calculate(res));

        List<String> split1 = splitter.splitLine("3 + 4 * (1 * 0)");
        Queue<String> res1 = converter.convertInfixToRPN(split1);
        System.out.println(res1);
        System.out.println(prnCalculator.calculate(res1));
    }
}
