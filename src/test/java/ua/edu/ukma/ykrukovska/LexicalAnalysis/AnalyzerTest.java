package ua.edu.ukma.ykrukovska.LexicalAnalysis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class AnalyzerTest {

    @Test
    public void findNoWordsFromMySurnameLetters() {
        LexicalClass lexicalClass = LexicalClass.SURNAME;
        Analyzer analyzer = new Analyzer(Collections.singletonList(lexicalClass));
        List<AnalysisResult> analysisResults = analyzer.analyzeLine("це не слово з літерами прізвища");
        List<AnalysisResult> res = findResult(analysisResults, lexicalClass);

        Assertions.assertEquals(0, res.size());
    }

    @Test
    public void findOneWordFromMySurnameLetters() {
        LexicalClass lexicalClass = LexicalClass.SURNAME;
        Analyzer analyzer = new Analyzer(Collections.singletonList(lexicalClass));
        List<AnalysisResult> analysisResults = analyzer.analyzeLine("тест Круковська тест");
        List<AnalysisResult> res = findResult(analysisResults, lexicalClass);

        Assertions.assertEquals(1, res.size());
    }

    @Test
    public void findAllWordsFromMySurnameLetters() {
        Analyzer analyzer = new Analyzer(Collections.singletonList(LexicalClass.SURNAME));
        List<AnalysisResult> res = analyzer.analyzeLine("крук ова АКА");

        Assertions.assertEquals(3, res.size());
    }

    @Test
    public void findAllNumbers() {
        LexicalClass lexicalClass = LexicalClass.NUMBER;
        Analyzer analyzer = new Analyzer(Collections.singletonList(lexicalClass));
        List<AnalysisResult> analysisResults = analyzer.analyzeLine("-2,0 -1.0 0 1.0 2,0");
        List<AnalysisResult> res = findResult(analysisResults, lexicalClass);

        Assertions.assertEquals(5, res.size());
    }

    @Test
    public void findAllNumbersAmongWords() {
        LexicalClass lexicalClass = LexicalClass.NUMBER;
        Analyzer analyzer = new Analyzer(Collections.singletonList(lexicalClass));
        List<AnalysisResult> analysisResults = analyzer.analyzeLine("-2,0 a -1.0 word 0 and 1.0 another 2,0 word");
        List<AnalysisResult> res = findResult(analysisResults, lexicalClass);

        Assertions.assertEquals(10, analysisResults.size());
        Assertions.assertEquals(5, res.size());
    }

    @Test
    public void findMailAllCorrect() {
        LexicalClass lexicalClass = LexicalClass.MAIL;
        Analyzer analyzer = new Analyzer(Collections.singletonList(lexicalClass));
        List<AnalysisResult> analysisResults = analyzer.analyzeLine("test1@gmail.com test.2@ukr.net test-3@mail.ru");
        List<AnalysisResult> res = findResult(analysisResults, lexicalClass);

        Assertions.assertEquals(3, res.size());
    }

    @Test
    public void findNoMail() {
        LexicalClass lexicalClass = LexicalClass.MAIL;
        Analyzer analyzer = new Analyzer(Collections.singletonList(lexicalClass));
        List<AnalysisResult> analysisResults = analyzer.analyzeLine("test1@gmail.c test2ukr.net");
        List<AnalysisResult> res = findResult(analysisResults, lexicalClass);

        Assertions.assertEquals(0, res.size());
    }

    @Test
    public void findAllSyntaxSymbols() {
        LexicalClass lexicalClass = LexicalClass.SYNTAX;
        Analyzer analyzer = new Analyzer(Collections.singletonList(lexicalClass));
        List<AnalysisResult> analysisResults = analyzer.analyzeLine("-hello!! it's me *");
        List<AnalysisResult> res = findResult(analysisResults, lexicalClass);

        Assertions.assertEquals(4, res.size());
    }

    @Test
    public void findAllPhoneNumbers() {
        LexicalClass lexicalClass = LexicalClass.PHONE_NUMBER;
        Analyzer analyzer = new Analyzer(Collections.singletonList(lexicalClass));
        List<AnalysisResult> analysisResults = analyzer.analyzeLine("(044) 890 12 34 +380 (44) 5678901 +380442345678 +380 44 123 45 67");
        List<AnalysisResult> res = findResult(analysisResults, lexicalClass);

        Assertions.assertEquals(3, res.size());
    }

    @Test
    public void findAllPhoneNumbersSeparatedByText() {
        LexicalClass lexicalClass = LexicalClass.PHONE_NUMBER;
        Analyzer analyzer = new Analyzer(Collections.singletonList(lexicalClass));
        List<AnalysisResult> analysisResults = analyzer.analyzeLine("(044) 890 12 34 or +380 (44) 5678901 !! +380442345678 and +380 44 123 45 67");
        List<AnalysisResult> res = findResult(analysisResults, lexicalClass);

        Assertions.assertEquals(3, res.size());
    }

    @Test
    public void findNoPhoneNumber() {
        LexicalClass lexicalClass = LexicalClass.PHONE_NUMBER;
        Analyzer analyzer = new Analyzer(Collections.singletonList(lexicalClass));
        List<AnalysisResult> analysisResults = analyzer.analyzeLine("+3801234567890987654");
        List<AnalysisResult> res = findResult(analysisResults, lexicalClass);

        Assertions.assertEquals(0, res.size());
    }

    @Test
    public void findThreeDifferentClasses() {
        Analyzer analyzer = new Analyzer(Arrays.asList(LexicalClass.SURNAME, LexicalClass.MAIL, LexicalClass.REJECT));
        List<AnalysisResult> analysisResults = analyzer.analyzeLine("Кака! Моя пошта - mail@gmail.com");
        List<AnalysisResult> surname = findResult(analysisResults, LexicalClass.SURNAME);
        List<AnalysisResult> mail = findResult(analysisResults, LexicalClass.MAIL);
        List<AnalysisResult> reject = findResult(analysisResults, LexicalClass.REJECT);

        Assertions.assertEquals(1, surname.size());
        Assertions.assertEquals(1, mail.size());
        Assertions.assertEquals(4, reject.size());
    }

    @Test
    public void findThreeDate() {
        LexicalClass lexicalClass = LexicalClass.DATE;
        Analyzer analyzer = new Analyzer(Collections.singletonList(lexicalClass));
        List<AnalysisResult> analysisResults = analyzer.analyzeLine("01-01-1970 or 05/09/2001 or 11.11.2020");
        List<AnalysisResult> res = findResult(analysisResults, lexicalClass);

        Assertions.assertEquals(3, res.size());
    }

    private List<AnalysisResult> findResult(List<AnalysisResult> analysisResults, LexicalClass lexicalClass) {
        List<AnalysisResult> res = new LinkedList<>();
        for (AnalysisResult analysisResult : analysisResults) {
            if (analysisResult.getLexicalClass().getClassName().equals(lexicalClass.getClassName())) {
                res.add(analysisResult);
            }
        }
        return res;
    }

}