package day2;

import utils.InputHandler;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Dive {
    private static void dive(Stream<String> inputs) {
        AtomicInteger horizontal = new AtomicInteger();
        AtomicInteger depth = new AtomicInteger();
        inputs.map(input -> input.split(" ")).forEach(input -> {
            switch(input[0]) {
                case "forward" -> horizontal.addAndGet(Integer.parseInt(input[1]));
                case "down" -> depth.addAndGet(Integer.parseInt(input[1]));
                case "up" -> depth.addAndGet(-Integer.parseInt(input[1]));
                default -> throw new IllegalStateException("Unexpected value: " + input[0]);
            }
        });
        System.out.printf("horizontal position %s * depth %s = %s%n", horizontal, depth, horizontal.get() * depth.get());
    }

    private static void diveWithAim(Stream<String> inputs) {
        AtomicInteger horizontal = new AtomicInteger();
        AtomicInteger depth = new AtomicInteger();
        AtomicInteger aim = new AtomicInteger();
        inputs.map(s -> s.split(" ")).forEach(input -> {
            switch(input[0]) {
                case "forward" -> {
                    horizontal.addAndGet(Integer.parseInt(input[1]));
                    depth.addAndGet(aim.get() * Integer.parseInt(input[1]));
                }
                case "down" -> aim.addAndGet(Integer.parseInt(input[1]));
                case "up" -> aim.addAndGet(-Integer.parseInt(input[1]));
                default -> throw new IllegalStateException("Unexpected value: " + input[0]);
            }
        });
        System.out.printf("horizontal position %s * depth %s = %s%n", horizontal, depth, horizontal.get() * depth.get());
    }

    public static void main(String[] args) {
        dive(InputHandler.getStringStream("day2/Dive.txt"));
        diveWithAim(InputHandler.getStringStream("day2/Dive.txt"));
    }
}
