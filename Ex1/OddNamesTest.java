package ForGit.Ex1;

import java.util.Scanner;

public class OddNamesTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OddNames oddNames = new OddNames(scanner.nextLine());
        System.out.println(oddNames.getOddNames());
        scanner.close();
    }
}
