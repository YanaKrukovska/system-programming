package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitterTest {

    @Test
    public void allSymbolsWithSpacesBetween() {
        Splitter splitter = new Splitter();
        List<String> res = splitter.splitLine("a + b * ( 2 + c ) ^ 2");
        assertEquals(11, res.size());
    }

    @Test
    public void allSymbolsWithoutSpacesBetween() {
        Splitter splitter = new Splitter();
        List<String> res = splitter.splitLine("a+b*(2+c)^3");
        assertEquals(11, res.size());
    }

    @Test
    public void allSymbolsWithMixedSpaceBetween() {
        Splitter splitter = new Splitter();
        List<String> res = splitter.splitLine("a + b*(2 + c)^3");
        assertEquals(11, res.size());
    }

    @Test
    public void splitWithFunctions() {
        Splitter splitter = new Splitter();
        List<String> res = splitter.splitLine("sin (a + b)");
        assertEquals(6, res.size());
    }
}