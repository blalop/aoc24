package aoc24;

import java.util.Arrays;
import java.util.List;

public class Day05Part1 {
    public static void main(String[] args) {
        String input = Utils.readFile("/inputs/05-input.txt");

        List<Rule> rules = input.lines()
                .filter(line -> line.contains("|"))
                .map(line -> {
                    String[] split = line.split("\\|");
                    return new Rule(split[0], split[1]);
                })
                .toList();

        List<List<String>> lines = input.lines()
                .filter(line -> line.contains(","))
                .map(line -> line.split(","))
                .map(Arrays::asList)
                .toList();

        List<List<String>> valid = lines.stream()
                .filter(line -> rules.stream().allMatch(rule -> validate(line, rule)))
                .toList();

        int sum = valid.stream()
                .map(l -> l.get(l.size() / 2))
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println(sum);
    }

    private static boolean validate(List<String> line, Rule rule) {
        if (!line.contains(rule.first) || !line.contains(rule.second)) {
            return true;
        }
        return line.indexOf(rule.first) < line.indexOf(rule.second);
    }

    record Rule(String first, String second) {
    }
}