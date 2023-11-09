package ForGit.Ex1;

import java.io.*;
import java.util.Scanner;

public class CheckValidNumber {
    private final File file;
    private final String firstValidNumFormula = "[0-9]{3}-[0-9]{3}-[0-9]{4}";
    private final String secondValidNumFormula = "\\([0-9]{3}\\)\\s[0-9]{3}-[0-9]{4}";

    public CheckValidNumber(File file) {
        this.file = file;
    }
    public void getValidNumbers() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            if (s.matches(firstValidNumFormula) || s.matches(secondValidNumFormula)){
                System.out.println(s);
            }
        }
    }
}
