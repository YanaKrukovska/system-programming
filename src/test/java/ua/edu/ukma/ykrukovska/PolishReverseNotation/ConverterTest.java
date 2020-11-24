package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ConverterTest {

    @Test
    void convertToString() {
        Splitter splitter = new Splitter();
        Converter converter = new Converter();

        List<String> expression = splitter.splitLine("50/(2*5)");
        Assertions.assertEquals("50 2 5 * / ", converter.convertToString(converter.convertInfixToRPN(expression)));
    }
}