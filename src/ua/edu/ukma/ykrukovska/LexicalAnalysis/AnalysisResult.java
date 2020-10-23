package ua.edu.ukma.ykrukovska.LexicalAnalysis;

public class AnalysisResult {

    private String lexeme;
    private LexicalClass lexicalClass;

    public AnalysisResult(String lexeme, LexicalClass lexicalClass) {
        this.lexeme = lexeme;
        this.lexicalClass = lexicalClass;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public LexicalClass getLexicalClass() {
        return lexicalClass;
    }

    public void setLexicalClass(LexicalClass lexicalClass) {
        this.lexicalClass = lexicalClass;
    }
}
