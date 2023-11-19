package ForGit.Ex2;

import java.util.Scanner;

public class SortNamesTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortNames sortNames = new SortNames(scanner.nextLine());
        System.out.println(sortNames.getSortedNames());
        scanner.close();
    }
}
//Ivan aleks oleg zelds