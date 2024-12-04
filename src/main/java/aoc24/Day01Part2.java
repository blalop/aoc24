package aoc24;

import java.util.List;
import java.util.Objects;

public class Day01Part2 {
    public static void main(String[] args) {
        String input = Utils.readFile("/inputs/01-input.txt");

        List<Integer> first = input.lines()
                .map(line -> line.split("\\s")[0])
                .map(Integer::valueOf)
                .toList();

        List<Integer> second = input.lines()
                .map(line -> line.split("\\s")[3])
                .map(Integer::valueOf)
                .toList();

        int sum = 0;
        for (int i : first) {
            int count = (int) second.stream().filter(j -> Objects.equals(i, j)).count();
            sum += i * count;
        }

        System.out.println(sum);
    }
}