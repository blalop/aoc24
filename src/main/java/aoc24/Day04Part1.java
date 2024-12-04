package aoc24;

public class Day04Part1 {
    public static void main(String[] args) {
        String input = Utils.readFile("/inputs/04-input.txt");

        char[][] array = input.lines()
                .map(String::toCharArray)
                .toArray(char[][]::new);
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 'X') {
                    for (int[] dir : directions) {
                        try {
                            char m = array[i + dir[0]][j + dir[1]];
                            char a = array[i + dir[0] * 2][j + dir[1] * 2];
                            char s = array[i + dir[0] * 3][j + dir[1] * 3];
                            if (m == 'M' && a == 'A' && s == 'S') {
                                count++;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            continue;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}