package day1;

import utils.InputHandler;
import utils.StreamUtils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Having some fun with streams leading to a pretty over engineered implementation for the Sonar Sweep \o/
 */
public class SonarSweep {
    private static void measure(String fileName, int slidingWindowSize) {
        AtomicInteger count = new AtomicInteger();
        Stream<Stream<String>> stream = StreamUtils.sliding(InputHandler.getStringStream(fileName).toList(), slidingWindowSize);
        stream.map(s -> s.mapToInt(Integer::parseInt).sum()).reduce((a, b) -> {
            if (a < b) {
                count.getAndIncrement();
            }
            return b;
        });
        System.out.println(count);
    }

    public static void main(String[] args) {
        measure("day1/SonarSweep.txt", 1);
        measure("day1/SonarSweep.txt", 3);
    }
}
