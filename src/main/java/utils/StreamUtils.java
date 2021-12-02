package utils;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamUtils {
    /**
     * Returns a Stream where each element is a Stream of 'size' subsequent elements
     */
    public static <T> Stream<Stream<T>> sliding(List<T> in, int size) {
        if (size > in.size()) {
            return Stream.empty();
        } else {
            return IntStream.range(0, in.size() - size + 1)
                    .mapToObj(start -> in.subList(start, start + size).stream());
        }
    }

    public static void main(String[] args) {
        IntStream test = IntStream.range(0, 10);
        test.forEach(System.out::println);
    }
}
