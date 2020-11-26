package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class ConverterTest {

    @Test
    void convertIndex() {
        Converter converter = new Converter();
        List<String> expression = Splitter.splitLine("A[i,j+1]");
        List<String> expectedResult = new LinkedList<>(Arrays.asList("A", "i", "j", "1", "+", "3", "]"));
        Assertions.assertEquals(converter.convertToString(expectedResult), converter.convertToString(converter.convertInfixToRPN(expression)));
    }

    @Test
    void convertIndexWithAssignment() {
        Converter converter = new Converter();
        List<String> expression = Splitter.splitLine("A = M[i,j+1]");
        List<String> expectedResult = new LinkedList<>(Arrays.asList("A", "M", "i", "j", "1", "+", "3", "]", "="));
        Assertions.assertEquals(converter.convertToString(expectedResult), converter.convertToString(converter.convertInfixToRPN(expression)));
    }

    @Test
    void convertToString() {
        Converter converter = new Converter();
        List<String> expression = Splitter.splitLine("50/(2*5)");
        Assertions.assertEquals("50 2 5 * / ", converter.convertToString(converter.convertInfixToRPN(expression)));
    }
}