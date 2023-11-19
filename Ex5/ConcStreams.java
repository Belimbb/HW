package ForGit.Ex5;

import java.util.stream.Stream;

public class ConcStreams {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        T[] firstArray = (T[]) first.toArray();
        T[] secondArray = (T[]) second.toArray();

        int minLength = Math.min(firstArray.length, secondArray.length);
        Stream<T> newFirst = Stream.of(firstArray).limit(minLength);
        Stream<T> newSecond = Stream.of(secondArray).limit(minLength);

        return Stream.concat(newFirst, newSecond);
    }
}
