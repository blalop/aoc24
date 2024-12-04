package aoc24;

public class Day04Part2 {
    public static void main(String[] args) {
        String input = Utils.readFile("/inputs/04-input.txt");

        char[][] array = input.lines()
                .map(String::toCharArray)
                .toArray(char[][]::new);

        int count = 0;

        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 1; j < array[i].length - 1; j++) {
                if (array[i][j] == 'A') {
                    char upperLeft = array[i - 1][j - 1];
                    char upperRight = array[i - 1][j + 1];
                    char lowerLeft = array[i + 1][j - 1];
                    char lowerRight = array[i + 1][j + 1];
                    String firstDiagonal = String.valueOf(upperLeft) + 'A' + String.valueOf(lowerRight);
                    String secondDiagonal = String.valueOf(upperRight) + 'A' + String.valueOf(lowerLeft);
                    if (firstDiagonal.equals("MAS") && secondDiagonal.equals("MAS")) {
                        count++;
                    }

                    if (firstDiagonal.equals("MAS") && secondDiagonal.equals("SAM")) {
                        count++;
                    }

                    if (firstDiagonal.equals("SAM") && secondDiagonal.equals("SAM")) {
                        count++;
                    }

                    if (firstDiagonal.equals("SAM") && secondDiagonal.equals("MAS")) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}