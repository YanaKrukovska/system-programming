package ua.edu.ukma.ykrukovska.LexicalAnalysis;

public class AnalysisResult implements Comparable<AnalysisResult> {

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

    @Override
    public String toString() {
        return lexeme + " - " + lexicalClass.getClassName();
    }

    @Override
    public int compareTo(AnalysisResult other) {
        return this.getLexeme().equals(other.getLexeme()) ? this.getLexicalClass().getClassName().compareTo(other.getLexicalClass().getClassName()) : this.getLexeme().compareTo(other.getLexeme());
    }
}
