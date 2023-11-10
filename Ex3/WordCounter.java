package ForGit.Ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hashMap.entrySet());

        entryList.sort(Map.Entry.comparingByValue());
        Collections.reverse(entryList);

        Map<String, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println(sortedHashMap);
    }
}
