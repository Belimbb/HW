package ForGit.Ex2;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.remove(2);
        System.out.println("list.size() = " + list.size());
        list.clear();
        System.out.println(list.get(1));
    }
}
