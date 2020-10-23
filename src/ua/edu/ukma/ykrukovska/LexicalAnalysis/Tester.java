package ua.edu.ukma.ykrukovska.LexicalAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        Analyzer analyzer = new Analyzer(Arrays.asList(
                new LexicalClass("Surname Class", Collections.singletonList("\\b[кКрРуУоОвВсСьЬаА]+\\b")),
                new LexicalClass("Mail Class", Collections.singletonList("([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)")),
                new LexicalClass("Phone Number Class", Arrays.asList("\\+(\\d{3}[\\- ]?)\\(\\d{2}\\) \\d{7}", "\\+\\d{12}\\b", "\\+?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{10,12}")),
                new LexicalClass("Number Class", Collections.singletonList("(\\-*)[0-9]+\\.?\\,?[0-9]+")),
                new LexicalClass("Syntax Class", Collections.singletonList("\\B[\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\\\\\^\\_\\`\\~]+\\B"))
        ));

        try {
            File file = new File("C:\\IdeaProjects\\system-programming\\src\\ua\\edu\\ukma\\ykrukovska\\LexicalAnalysis\\Source.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                analyzer.findMatches(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
