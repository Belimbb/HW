package ForGit.Ex4;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class InfiniteStream {
    private long a;
    private long c;
    public AtomicLong seed;
    private long m;

    public InfiniteStream(long a, long c, long m) {
        this.a = a;
        this.c = c;
        this.m = m;
    }
    public Stream<Long> getInfStream(long seed){
        this.seed = new AtomicLong(seed);
        return LongStream.iterate(seed, value -> (a * value + c) % m).boxed();
    }
}
