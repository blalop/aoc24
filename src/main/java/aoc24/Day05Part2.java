package aoc24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day05Part2 {
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

        List<List<String>> invalid = lines.stream()
                .filter(line -> rules.stream().anyMatch(rule -> !validate(line, rule)))
                .toList();

        Comparator<String> ruleComparator = new RuleComparator(rules);

        int sum = invalid.stream()
                .peek(l -> l.sort(ruleComparator))
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

    static class RuleComparator implements Comparator<String> {
        private final List<Rule> rules;

        RuleComparator(List<Rule> rules) {
            this.rules = rules;
        }

        @Override
        public int compare(String a, String b) {
            for (Rule rule : rules) {
                if (a.equals(rule.first) && b.equals(rule.second)) {
                    return -1;
                }
                if (a.equals(rule.second) && b.equals(rule.first)) {
                    return 1;
                }
            }
            return 0;
        }
    }
}