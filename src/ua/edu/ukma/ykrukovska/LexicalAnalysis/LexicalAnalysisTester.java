package ua.edu.ukma.ykrukovska.LexicalAnalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class LexicalAnalysisTester {

    public static void main(String[] args) {
        List<AnalysisResult> results = new LinkedList<>();


        Analyzer analyzer = new Analyzer(Arrays.asList(LexicalClass.SURNAME, LexicalClass.PHONE_NUMBER, LexicalClass.MAIL, LexicalClass.NUMBER, LexicalClass.SYNTAX, LexicalClass.REJECT));
        try {
            File file = new File("C:\\IdeaProjects\\system-programming\\src\\ua\\edu\\ukma\\ykrukovska\\LexicalAnalysis\\Source.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                results.addAll(analyzer.analyzeLine(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("ORIGINAL:");
        printResults(results);

        results = removeDuplicates(results);

        System.out.println("ALPHABETICALLY:");
        printResults(sortInAlphabeticalOrder(results));

        System.out.println("BY CLASS:");
        printResults(sortByClass(results));
    }

    private static List<AnalysisResult> removeDuplicates(List<AnalysisResult> results) {
        Set<AnalysisResult> res = new TreeSet<>(results);
        return new LinkedList<>(res);
    }

    private static List<AnalysisResult> sortInAlphabeticalOrder(List<AnalysisResult> results) {
        results.sort((o1, o2) -> o1.getLexeme().compareTo(o2.toString()));
        return results;
    }

    private static List<AnalysisResult> sortByClass(List<AnalysisResult> results) {
        results.sort(Comparator.comparing(o -> o.getLexicalClass().getClassName()));
        return results;
    }

    private static void printResults(List<AnalysisResult> results) {
        results.forEach(System.out::println);
        System.out.println("");
    }

}
