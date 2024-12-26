package aoc2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day4p2 {
    public static void main(String[] args) throws IOException {
        Day4p2 day4 = new Day4p2();
        List<String> input = Files.readAllLines(Paths.get("src/main/resources/day4/input"));
        char[][] matrix = day4.parse(input);
        day4.check(matrix);
    }

    char[][] parse(List<String> input) {
        char[][] matrix = new char[input.getFirst().length()][input.size()];
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).length(); j++) {
                matrix[j][i] = input.get(i).charAt(j);
            }
        }
        return matrix;
    }

    void check(char[][] input) {
        int count = 0;
        for (int x = 0; x < input.length; x++) {
            for (int y = 0; y < input[x].length; y++) {
                if (input[x][y] == 'A') {
                    if (isX_MAS(input, x, y, input.length, input[x].length)) {
                        System.out.println("x:" + x + ", y:" + y);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    boolean isX_MAS(char[][] input, int x, int y, int x_max, int y_max) {
        return (toTopLeft(input, x, y, x_max, y_max) || toBottomRight(input, x, y, x_max, y_max)) && (toTopRight(input, x, y, x_max, y_max) || toBottomLeft(input, x, y, x_max, y_max));
    }


    boolean toTopLeft(char[][] input, int x, int y, int x_max, int y_max) {
        if (boundCheck(x, y, x_max, y_max)) {
            return input[x + 1][y + 1] == 'M' && input[x - 1][y - 1] == 'S';
        }
        return false;
    }

    boolean toTopRight(char[][] input, int x, int y, int x_max, int y_max) {
        if (boundCheck(x, y, x_max, y_max)) {
            return input[x - 1][y + 1] == 'M' && input[x + 1][y - 1] == 'S';
        }
        return false;
    }

    boolean toBottomLeft(char[][] input, int x, int y, int x_max, int y_max) {
        if (boundCheck(x, y, x_max, y_max)) {
            return input[x + 1][y - 1] == 'M' && input[x - 1][y + 1] == 'S';
        }
        return false;
    }

    boolean toBottomRight(char[][] input, int x, int y, int x_max, int y_max) {
        if (boundCheck(x, y, x_max, y_max)) {
            return input[x - 1][y - 1] == 'M' && input[x + 1][y + 1] == 'S';
        }
        return false;
    }

    boolean boundCheck(int x, int y, int x_max, int y_max) {
        return topBoundCheck(x, y, x_max, y_max) && leftBoundCheck(x, y, x_max, y_max) && bottomBoundCheck(x, y, x_max, y_max) && rightBoundCheck(x, y, x_max, y_max);
    }

    boolean topBoundCheck(int x, int y, int x_max, int y_max) {
        return y > 0;
    }

    boolean leftBoundCheck(int x, int y, int x_max, int y_max) {
        return x > 0;
    }

    boolean rightBoundCheck(int x, int y, int x_max, int y_max) {
        return x < x_max - 1;
    }

    boolean bottomBoundCheck(int x, int y, int x_max, int y_max) {
        return y < y_max - 1;
    }
}
