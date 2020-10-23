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

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        AnalysisResult other = (AnalysisResult) obj;
        return this.getLexeme().equals(other.getLexeme());
    }

    @Override
    public int hashCode() {
        return lexeme.hashCode();
    }

    @Override
    public String toString() {
        return lexeme + " - " + lexicalClass.getClassName();
    }


}
