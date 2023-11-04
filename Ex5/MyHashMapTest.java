package ForGit.Ex5;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("abc1", 1);
        myHashMap.put("abc2", 2);
        myHashMap.put("abc3", 3);
        myHashMap.put("abc4", 4);
        System.out.println("myHashMap.get(\"abc3\") = " + myHashMap.get("abc3"));
        System.out.println("myHashMap.size() = " + myHashMap.size());
        myHashMap.remove("abc3");
        System.out.println("myHashMap.size() = " + myHashMap.size());
        System.out.println("myHashMap.get(\"abc3\") = " + myHashMap.get("abc3"));
        myHashMap.clear();
        System.out.println("myHashMap.size()final = " + myHashMap.size());
    }
}
