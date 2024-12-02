package aoc24;

import java.util.List;
import java.util.stream.IntStream;

public class Day01Part1 {
    void main() {
        String input = Utils.readFile("/inputs/01-input.txt");

        List<Integer> first = input.lines()
                .map(line -> line.split("\\s")[0])
                .map(Integer::valueOf)
                .sorted()
                .toList();

        List<Integer> second = input.lines()
                .map(line -> line.split("\\s")[3])
                .map(Integer::valueOf)
                .sorted()
                .toList();

        int diff = IntStream.range(0, first.size())
                .map(i -> first.get(i) - second.get(i))
                .map(Math::abs)
                .sum();

        System.out.println(diff);
    }
}