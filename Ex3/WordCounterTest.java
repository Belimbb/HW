package ForGit.Ex3;

import java.io.File;
import java.io.FileNotFoundException;

public class WordCounterTest {
    public static void main(String[] args) throws FileNotFoundException {
        WordCounter wordCounter = new WordCounter(new File("C:\\Users\\PC\\IdeaProjects\\Start\\src\\main\\java\\ForGit\\Ex3\\words.txt"));
        wordCounter.SOUTNumbersCount();
    }

}
