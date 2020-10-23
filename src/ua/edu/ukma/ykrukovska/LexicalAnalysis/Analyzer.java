package ua.edu.ukma.ykrukovska.LexicalAnalysis;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {

    private List<LexicalClass> lexicalClasses;
    private List<AnalysisResult> results;

    public Analyzer(List<LexicalClass> lexicalClasses) {
        this.lexicalClasses = lexicalClasses;
        this.results = new LinkedList<>();
    }

    public void findMatches(String line) {
        String newLine = line;
        for (LexicalClass lexicalClass : lexicalClasses) {
            List<String> regExpressions = lexicalClass.getRegExpressions();
            for (String regExpression : regExpressions) {
                newLine = findMatches(newLine, lexicalClass, regExpression);
            }
        }

        addRejects(newLine);
    }

    private void addRejects(String newLine) {
        String[] rejects = newLine.split(" ");
        for (String reject : rejects) {
            if (!reject.trim().isEmpty()) {
                results.add(new AnalysisResult(reject, new LexicalClass("Reject", new LinkedList<>())));
            }
        }
    }

    private String findMatches(String line, LexicalClass lexicalClass, String regExpression) {
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

    public List<LexicalClass> getLexicalClasses() {
        return lexicalClasses;
    }

    public void setLexicalClasses(List<LexicalClass> lexicalClasses) {
        this.lexicalClasses = lexicalClasses;
    }

    public List<AnalysisResult> getResults() {
        return results;
    }

    public void setResults(List<AnalysisResult> results) {
        this.results = results;
    }
}
