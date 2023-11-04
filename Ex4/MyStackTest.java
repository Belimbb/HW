package ForGit.Ex4;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("1");
        stack.push("2");
        stack.remove(1);
        stack.push("3");
        System.out.println(stack);
    }
}
