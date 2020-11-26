package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitterTest {

    @Test
    public void allSymbolsWithSpacesBetween() {
        List<String> res = Splitter.splitLine("a + b * ( 2 + c ) ^ 2");
        assertEquals(11, res.size());
    }

    @Test
    public void allSymbolsWithoutSpacesBetween() {
        List<String> res = Splitter.splitLine("a+b*(2+c)^3");
        assertEquals(11, res.size());
    }

    @Test
    public void allSymbolsWithMixedSpaceBetween() {
        List<String> res = Splitter.splitLine("a + b*(2 + c)^3");
        assertEquals(11, res.size());
    }

    @Test
    public void splitWithFunctions() {
        List<String> res = Splitter.splitLine("sin (a + b)");
        assertEquals(6, res.size());
    }

    @Test
    public void splitWithIndexBrackets() {
        List<String> res = Splitter.splitLine("A[i]");
        assertEquals(4, res.size());
    }

    @Test
    public void splitWithMultipleIndex() {
        List<String> res = Splitter.splitLine("A[i, i + 1, i + 2]");
        assertEquals(12, res.size());
    }
}