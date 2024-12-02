package aoc24;

import java.util.Arrays;
import java.util.List;

public class Day02Part1 {
    void main() {
        String input = Utils.readFile("/inputs/02-input.txt");

        long count = input.lines()
                .map(Day02Part1::parse)
                .filter(Day02Part1::validate)
                .count();

        System.out.println(count);
    }

    private static List<Integer> parse(String s) {
        return Arrays.stream(s.split(" "))
                .map(Integer::valueOf)
                .toList();
    }

    private static boolean validate(List<Integer> ints) {
        boolean increase = ints.get(1) > ints.get(0);
        for (int i = 0; i < ints.size() - 1; i++) {
            boolean decrease = ints.get(i + 1) < ints.get(i);
            if (increase == decrease) {
                return false;
            }

            int diff = Math.abs(ints.get(i + 1) - ints.get(i));
            if (diff > 3 || diff == 0) {
                return false;
            }
        }

        return true;
    }

}