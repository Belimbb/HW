package ForGit.Ex2;

import java.io.File;
import java.io.FileNotFoundException;

public class FromFileToJSONTest {
    public static void main(String[] args) throws FileNotFoundException {
        FromFileToJSON json = new FromFileToJSON(new File("C:\\Users\\PC\\IdeaProjects\\Start\\src\\main\\java\\ForGit\\Ex2\\file.txt"));
        json.convert();
    }
}
