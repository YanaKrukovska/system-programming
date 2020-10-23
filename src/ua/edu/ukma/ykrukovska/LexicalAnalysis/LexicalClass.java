package ua.edu.ukma.ykrukovska.LexicalAnalysis;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public enum LexicalClass {

    SURNAME("Surname Class", Collections.singletonList("\\b[кКрРуУоОвВсСьЬаА]+\\b")),
    MAIL("Mail Class", Collections.singletonList("([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)")),
    PHONE_NUMBER("Phone Number Class", Arrays.asList("\\+(\\d{3}[\\- ]?)\\(\\d{2}\\) \\d{7}", "\\+\\d{12}\\b", "\\+?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{10,12}")),
    NUMBER("Number Class", Collections.singletonList("(\\-*)[0-9]+\\.?\\,?[0-9]+")),
    SYNTAX("Syntax Class", Collections.singletonList("\\B[\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\\\\\^\\_\\`\\~]+\\B")),
    REJECT("Reject", new LinkedList<>());

    private String className;
    private List<String> regExpressions;

    LexicalClass(String className, List<String> regExpressions) {
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
