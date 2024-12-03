package aoc24;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03Part1 {
    void main() {
        String input = Utils.readFile("/inputs/03-input.txt");

        int sum = 0;
        Matcher matcher = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)").matcher(input);
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
        }

        System.out.println(sum);
    }

}