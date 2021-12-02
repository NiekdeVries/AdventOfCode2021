package Util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InputHandler {
    private InputStream getInputStream(final String fileName) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);
        if (ioStream == null)
            throw new IllegalArgumentException(fileName + " could not be found");
        return ioStream;
    }

    public static Stream<String> getStringStream(final String fileName) {
        return new BufferedReader(new InputStreamReader(new InputHandler().getInputStream(fileName))).lines();
    }

    public static IntStream getIntStream(final String fileName) {
        return getStringStream(fileName).mapToInt(Integer::parseInt);
    }
}
