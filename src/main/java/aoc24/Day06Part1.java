package aoc24;

import java.util.Arrays;
import java.util.List;

public class Day06Part1 {
    public static void main(String[] args) {
        String input = Utils.readFile("/inputs/06-input.txt");
        char[][] map = Arrays.stream(input.split("\n")).map(String::toCharArray).toArray(char[][]::new);
        char[][] traversed = Arrays.stream(input.split("\n")).map(String::toCharArray).toArray(char[][]::new);
        int xSize = map.length;
        int ySize = map[0].length;
        Pair direction = new Pair(-1, 0);
        Pair position = new Pair(0, 0);

        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                if (map[i][j] == '^') {
                    traversed[i][j] = 'X';
                    position = new Pair(i, j);
                    break;
                }
            }
        }

        int nextX;
        int nextY;
        do {
            do {
                position = position.add(direction);
                traversed[position.x()][position.y()] = 'X';

                nextX = position.x + direction.x;
                nextY = position.y + direction.y;
            } while (new Pair(nextX, nextY).inBounds(xSize, ySize) && map[nextX][nextY] != '#');
            direction = direction.rotateRight();

        } while (new Pair(nextX, nextY).inBounds(xSize, ySize));


        int steps = 0;
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                if (traversed[i][j] == 'X') {
                    steps++;
                }
            }
        }

        System.out.println(steps);
    }

    record Pair(int x, int y) {
        private static final List<Pair> ORIENTATIONS = List.of(new Pair(-1, 0), new Pair(0, 1), new Pair(1, 0), new Pair(0, -1));

        Pair add(Pair other) {
            return new Pair(x + other.x, y + other.y);
        }

        Pair rotateRight() {
            int current = ORIENTATIONS.indexOf(this);
            return ORIENTATIONS.get((current + 1) % ORIENTATIONS.size());
        }

        boolean inBounds(int x, int y) {
            return this.x >= 0 && this.y >= 0 && this.x < x && this.y < y;
        }

    }
}