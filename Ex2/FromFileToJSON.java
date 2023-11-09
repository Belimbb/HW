package ForGit.Ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FromFileToJSON {
    private final File file;

    public FromFileToJSON(File file) {
        this.file = file;
    }
    private ArrayList<User> read() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        ArrayList<User> arr = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] info = s.split(" ");
            arr.add(new User(info[0], Integer.parseInt(info[1])));
        }
        return arr;
    }
    public void convert() throws FileNotFoundException {
        ArrayList<User> info = read();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(info);
        System.out.println(json);
    }
}

