package ForGit.Ex5;

import java.util.stream.Stream;

public class ConcStreamsTest {
    public static void main(String[] args) {
        Stream<Integer> firstStream = Stream.of(1, 2, 3);
        Stream<Integer> secondStream = Stream.of(4, 6);

        Stream<Integer> result = ConcStreams.zip(firstStream, secondStream);
        result.forEach(System.out::println);
    }
}
