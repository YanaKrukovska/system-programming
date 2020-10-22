package ua;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    /*
    *  regex matchesMail("([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)");
     regex matchesSyntax(
             "[\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\\\\\^\\_\\`\\~]+");
     regex matchesNumber("(\\-*)[0-9]+\\.?\\,?[0-9]+");

     regex matchesPhoneNumber0("\\+\\d{12}$");
     regex matchesPhoneNumber1("(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
     regex matchesPhoneNumber2("\\+(\\d{3}[\\- ]?)\\(\\d{2}\\) \\d{7}$");*/



    public static void main(String[] args) {

        try {
            File myObj = new File("C:\\IdeaProjects\\system-programming\\src\\ua\\Source.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Pattern pattern = Pattern.compile("\\b[кКрРуУоОвВсСьЬаА]+\\b");
                Matcher matcher = pattern.matcher(data);
                while (matcher.find()) {
                    System.out.println(data.substring(matcher.start(), matcher.end()));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
