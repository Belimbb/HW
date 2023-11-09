package ForGit.Ex1;
import java.io.*;
public class CheckValidNumberTest {
    public static void main(String[] args) throws FileNotFoundException {
        CheckValidNumber validNumbers = new CheckValidNumber(new File("C:\\Users\\PC\\IdeaProjects\\Start\\src\\main\\java\\ForGit\\Ex1\\file.txt"));
        validNumbers.getValidNumbers();
    }
}
