package aoc24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Day02Part2 {
    public static void main(String[] args) {
        String input = Utils.readFile("/inputs/02-input.txt");

        Predicate<List<Integer>> validatePredicate = Day02Part2::validate;

        long count = input.lines()
                .map(Day02Part2::parse)
                .filter(validatePredicate)
                .count();

        count += input.lines()
                .map(Day02Part2::parse)
                .filter(validatePredicate.negate())
                .filter(Day02Part2::revalidate)
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


    private static boolean revalidate(List<Integer> integers) {
        for (int i = 0; i < integers.size(); i++) {
            List<Integer> copy = new ArrayList<>(List.copyOf(integers));
            copy.remove(i);
            if (validate(copy)) {
                return true;
            }
        }
        return false;
    }
}