package ua.edu.ukma.ykrukovska.PolishReverseNotation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    public List<String> splitLine(String line) {
        Pattern pattern = Pattern.compile("-?[0-9.]+|[A-Za-z]+|[-+*/()^]");
        Matcher match = pattern.matcher(line);
        List<String> result = new ArrayList<>();
        while (match.find()) {
            result.add(match.group());
        }
        return result;
    }

}
