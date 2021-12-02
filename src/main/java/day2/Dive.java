package day2;

import utils.InputHandler;

import java.util.stream.Stream;

public class Dive {
    private static int dive(Stream<String> inputs) {
        int horizontal_pos = 0, depth = 0;
        for (String[] input : inputs.map(s -> s.split(" ")).toList()) {
            switch(input[0]) {
                case "forward" -> horizontal_pos += Integer.parseInt(input[1]);
                case "down" -> depth += Integer.parseInt(input[1]);
                case "up" -> depth -= Integer.parseInt(input[1]);
                default -> throw new IllegalStateException("Unexpected value: " + input[0]);
            }
        }
        System.out.println("horizontal position: " + horizontal_pos + ", depth: " + depth);
        return horizontal_pos * depth;
    }

    private static int diveWithAim(Stream<String> inputs) {
        int horizontal_pos = 0, depth = 0, aim = 0;
        for (String[] input : inputs.map(s -> s.split(" ")).toList()) {
            switch(input[0]) {
                case "forward" -> {
                    horizontal_pos += Integer.parseInt(input[1]);
                    depth +=  aim * Integer.parseInt(input[1]);
                }
                case "down" -> aim += Integer.parseInt(input[1]);
                case "up" -> aim -= Integer.parseInt(input[1]);
                default -> throw new IllegalStateException("Unexpected value: " + input[0]);
            }
        }
        System.out.println("horizontal position: " + horizontal_pos + ", depth: " + depth);
        return horizontal_pos * depth;
    }

    public static void main(String[] args) {
        System.out.println("horizontal position * depth = " + dive(InputHandler.getStringStream("day2/Dive.txt")));
        System.out.println("horizontal position * depth = " + diveWithAim(InputHandler.getStringStream("day2/Dive.txt")));
    }
}
