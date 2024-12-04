package aoc24;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03Part2 {
    public static void main(String[] args) {
        String input = Utils.readFile("/inputs/03-input.txt");

        int sum = 0;
        StringBuilder sb = new StringBuilder();

        Matcher firstDoMatcher = Pattern.compile("(.*?)(do)").matcher(input);
        firstDoMatcher.find();
        sb.append(firstDoMatcher.group());

        Matcher doMatcher = Pattern.compile("do\\(\\)(.*?)(?=do|$)").matcher(input);
        while (doMatcher.find()) {
            sb.append(doMatcher.group());
        }
        String doString = sb.toString();

        Matcher matcher = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)").matcher(doString);
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
        }
        System.out.println(sum);
    }
}