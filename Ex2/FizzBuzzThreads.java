package ForGit.Ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FizzBuzzThreads {
    private List<Integer> numbers;
    private final Object lock = new Object();
    private volatile boolean isFizz, isBuzz, isFizzBuzz;

    public FizzBuzzThreads(int n) {
        this.numbers = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
    }

    public void getFB() {
        for (int number : numbers) {
            Thread A = new Thread(() -> {
                setFizz(fizz(number));
            });
            Thread B = new Thread(() -> {
                setBuzz(buzz(number));
            });
            Thread C = new Thread(() -> {
                setFizzBuzz(fizzbuzz(number));
            });
            Thread D = new Thread(() -> {
                try {
                    Thread.sleep(200);
                    A.join();
                    B.join();
                    C.join();
                    processNumber(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            A.start();
            B.start();
            C.start();
            D.start();

            try {
                D.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void setFizz(Optional<String> result) {
        synchronized (lock) {
            isFizz = result.isPresent();
        }
    }

    private void setBuzz(Optional<String> result) {
        synchronized (lock) {
            isBuzz = result.isPresent();
        }
    }

    private void setFizzBuzz(Optional<String> result) {
        synchronized (lock) {
            isFizzBuzz = result.isPresent();
        }
    }

    private void processNumber(int number) {
        synchronized (lock) {
            if (isFizzBuzz) {
                number("fizzbuzz");
            } else if (isFizz) {
                number("fizz");
            } else if (isBuzz) {
                number("buzz");
            } else {
                number(String.valueOf(number));
            }

            // Reset the flags
            isFizz = false;
            isBuzz = false;
            isFizzBuzz = false;
        }
    }

    private Optional<String> fizz(int num) {
        return (num % 3 == 0) ? Optional.of("fizz") : Optional.empty();
    }

    private Optional<String> buzz(int num) {
        return (num % 5 == 0) ? Optional.of("buzz") : Optional.empty();
    }

    private Optional<String> fizzbuzz(int num) {
        return (num % 3 == 0 && num % 5 == 0) ? Optional.of("fizzbuzz") : Optional.empty();
    }

    private void number(String element) {
        System.out.print(element + ", ");
    }

    public static void main(String[] args) {
        FizzBuzzThreads fizzBuzzThreads = new FizzBuzzThreads(15);
        fizzBuzzThreads.getFB();
    }
}
