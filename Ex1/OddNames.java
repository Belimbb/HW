package ForGit.Ex1;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OddNames {
    private Optional<String> names;

    public OddNames(String names) {
        this.names = Optional.ofNullable(names);
    }
    public String getOddNames() {
        if (names.isEmpty() || names.get().isEmpty()) {
            return "String is empty!";
        }
        Optional<List<String>> optionalList = names.map(s -> List.of(s.split(" ")));

        List<String> nameList = optionalList.orElseThrow();
        AtomicInteger atomicInteger = new AtomicInteger(0);

        String result = nameList.stream()
                .map(n -> n + " " + atomicInteger.incrementAndGet())
                .filter(n -> atomicInteger.get() % 2 != 0)
                .collect(Collectors.joining(" "));
        return result;
    }
}
