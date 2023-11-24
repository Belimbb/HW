package ForGit.Ex1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Stopwatch {
    private volatile AtomicInteger counter = new AtomicInteger(0);
    public void secondsTimer(){
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
        ses.scheduleAtFixedRate(
                () -> System.out.println(counter.incrementAndGet()+" seconds from start"),
                1,
                1,
                TimeUnit.SECONDS
        );
        ses.scheduleAtFixedRate(
                () -> System.out.println("5 seconds have passed"),
                5,
                5,
                TimeUnit.SECONDS
        );
    }
}
