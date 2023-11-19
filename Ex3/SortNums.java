package ForGit.Ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortNums {
    private ArrayList<String> nums;

    public SortNums(String[] nums) {
        this.nums = new ArrayList<>(Arrays.asList(nums));
    }
    public String getSortedNums(){
        if (nums.isEmpty()){
            return "String is empty!";
        }
        List<String> result = nums.stream()
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .toList();
        String str = result.stream()
                .sorted()
                .collect(Collectors.joining(", "));
        return str;
    }
}
