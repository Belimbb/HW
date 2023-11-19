package ForGit.Ex4;

public class InfiniteStreamTest {
    public static void main(String[] args) {
        InfiniteStream infiniteStream = new InfiniteStream(25214903917L, 11L, 2^48);
        infiniteStream.getInfStream(14)
                .limit(10)
                .forEach(System.out::println);
    }
}
