package ua.edu.ukma.ykrukovska.LexicalAnalysis;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {

    private List<LexicalClass> lexicalClasses;

    public Analyzer(List<LexicalClass> lexicalClasses) {
        this.lexicalClasses = lexicalClasses;
    }

    public List<AnalysisResult> analyzeLine(String line) {
        String newLine = line;
        List<AnalysisResult> results = new LinkedList<>();
        for (LexicalClass lexicalClass : lexicalClasses) {
            List<String> regExpressions = lexicalClass.getRegExpressions();
            for (String regExpression : regExpressions) {
                newLine = findMatches(newLine, lexicalClass, regExpression, results);
            }
        }
        addRejects(newLine, results);
        return results;
    }

    private String findMatches(String line, LexicalClass lexicalClass, String regExpression, List<AnalysisResult> results) {
        Pattern pattern = Pattern.compile(regExpression);
        Matcher matcher = pattern.matcher(line);

        String tempLine = line;
        while (matcher.find()) {
            String match = tempLine.substring(matcher.start(), matcher.end());
            results.add(new AnalysisResult(match, lexicalClass));
            line = line.replace(match, "");
        }
        return line;
    }

    private void addRejects(String newLine, List<AnalysisResult> results) {
        String[] rejects = newLine.split(" ");
        for (String reject : rejects) {
            if (!reject.trim().isEmpty()) {
                results.add(new AnalysisResult(reject, LexicalClass.REJECT));
            }
        }
    }

    public List<LexicalClass> getLexicalClasses() {
        return lexicalClasses;
    }

    public void setLexicalClasses(List<LexicalClass> lexicalClasses) {
        this.lexicalClasses = lexicalClasses;
    }

}
