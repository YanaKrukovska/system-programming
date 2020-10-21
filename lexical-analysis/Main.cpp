// Created on 20.10.2020.

#include <iostream>
#include <fstream>
#include "string"
#include "regex"
#include <windows.h>

using namespace std;

int main() {
    SetConsoleOutputCP(CP_UTF8);

    string line;
    ifstream myfile;
    myfile.open("C:/Users/squir/CLionProjects/system-programming/lexical-analysis/Source.txt");

    if (!myfile.is_open()) {
        perror("Error open");
        exit(EXIT_FAILURE);
    }
    regex matchesSurname("[кКрРуКовВсСьЬаА]+");
    regex matchesMail("([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)");
    regex matchesSyntax(
            "[\\!\\\"\\#\\$\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\>\\=\\?\\@\\[\\]\\{\\}\\\\\\\\\\^\\_\\`\\~]+");
    regex matchesNumber("(\\-*)[0-9]+\\.?\\,?[0-9]+");

    regex matchesPhoneNumber0("\\+\\d{12}$");
    regex matchesPhoneNumber1("(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
    regex matchesPhoneNumber2("\\+(\\d{3}[\\- ]?)\\(\\d{2}\\) \\d{7}$");

    while (getline(myfile, line)) {
        if (regex_match(line, matchesSurname)) {
            cout << line << " - surname class" << endl;
        } else if (regex_match(line, matchesMail)) {
            cout << line << " - mail class" << endl;
        } else if (regex_match(line, matchesSyntax)) {
            cout << line << " - syntax class" << endl;
        } else if (regex_match(line, matchesNumber)) {
            cout << line << " - number class" << endl;
        } else if (regex_match(line, matchesPhoneNumber0) || regex_match(line, matchesPhoneNumber1) ||
                   regex_match(line, matchesPhoneNumber2)) {
            cout << line << " - phone number class" << endl;
        } else {
            cout << line << " - doesn't belong to any class" << endl;
        }
    }

}