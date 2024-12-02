package aoc24;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Utils {

    public static String readFile(String filename) {
        try (var inputStream = Utils.class.getResourceAsStream(filename)) {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
