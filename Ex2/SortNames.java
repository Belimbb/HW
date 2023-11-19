package ForGit.Ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortNames {
    private ArrayList<String> names;

    public SortNames(String names) {
        this.names = new ArrayList<String>(Arrays.asList(names.split(" ")));
    }
    public ArrayList<String> getSortedNames(){
        names.replaceAll(String::toUpperCase);
        ArrayList<String> arr = (ArrayList<String>) names.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return arr;
    }
}
