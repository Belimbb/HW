package ForGit.Ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter {
    private final File file;

    public WordCounter(File file) {
        this.file = file;
    }
    private ArrayList<String> read() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        ArrayList<String> arr = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] info = s.replaceAll("\\s{2,}", " ").split(" ");
            Collections.addAll(arr, info);
        }
        return arr;
    }
    public void SOUTNumbersCount() throws FileNotFoundException {
        ArrayList<String> dirtyArr = read();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String elem:dirtyArr){
            if (hashMap.get(elem) != null){
                hashMap.put(elem, hashMap.get(elem) + 1);
            }else {
                hashMap.put(elem, 1);
            }
        }
        System.out.println(hashMap);
    }
}
