package ForGit.Ex3;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");
        queue.add("6");
        queue.add("7");
        queue.add("8");
        queue.add("9");
        queue.add("10");
        queue.add("11");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
    }
}
