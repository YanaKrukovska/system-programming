package ua.edu.ukma.ykrukovska.LexicalAnalysis;

import java.util.List;

public class LexicalClass {

    private String className;
    private List<String> regExpressions;

    public LexicalClass(String className, List<String> regExpressions) {
        this.className = className;
        this.regExpressions = regExpressions;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getRegExpressions() {
        return regExpressions;
    }

    public void setRegExpressions(List<String> regExpressions) {
        this.regExpressions = regExpressions;
    }

}
