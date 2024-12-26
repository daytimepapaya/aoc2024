package aoc2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day4 {
    public static void main(String[] args) throws IOException {
        Day4 day4 = new Day4();
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
                if (input[x][y] == 'X') {
                    if (toTop(input, x, y, input.length, input[x].length)) {
                        System.out.println("x:" + x + ", y:" + y);
                        count++;
                    }
                    if (toBottom(input, x, y, input.length, input[x].length)) {
                        System.out.println("x:" + x + ", y:" + y);
                        count++;

                    }
                    if (toLeft(input, x, y, input.length, input[x].length)) {
                        System.out.println("x:" + x + ", y:" + y);
                        count++;
                    }
                    if (toRight(input, x, y, input.length, input[x].length)) {
                        System.out.println("x:" + x + ", y:" + y);
                        count++;
                    }
                    if (toTopLeft(input, x, y, input.length, input[x].length)) {
                        System.out.println("x:" + x + ", y:" + y);
                        count++;
                    }
                    if (toTopRight(input, x, y, input.length, input[x].length)) {
                        System.out.println("x:" + x + ", y:" + y);
                        count++;
                    }
                    if (toBottomLeft(input, x, y, input.length, input[x].length)) {
                        System.out.println("x:" + x + ", y:" + y);
                        count++;
                    }
                    if (toBottomRight(input, x, y, input.length, input[x].length)) {
                        System.out.println("x:" + x + ", y:" + y);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    boolean toTopLeft(char[][] input, int x, int y, int x_max, int y_max) {
        if (topBoundCheck(x, y, x_max, y_max) && leftBoundCheck(x, y, x_max, y_max)) {
            return input[x - 1][y - 1] == 'M' && input[x - 2][y - 2] == 'A' && input[x - 3][y - 3] == 'S';
        }
        return false;
    }

    boolean toTopRight(char[][] input, int x, int y, int x_max, int y_max) {
        if (topBoundCheck(x, y, x_max, y_max) && rightBoundCheck(x, y, x_max, y_max)) {
            return input[x + 1][y - 1] == 'M' && input[x + 2][y - 2] == 'A' && input[x + 3][y - 3] == 'S';
        }
        return false;
    }

    boolean toBottomLeft(char[][] input, int x, int y, int x_max, int y_max) {
        if (bottomBoundCheck(x, y, x_max, y_max) && leftBoundCheck(x, y, x_max, y_max)) {
            return input[x - 1][y + 1] == 'M' && input[x - 2][y + 2] == 'A' && input[x - 3][y + 3] == 'S';
        }
        return false;
    }

    boolean toBottomRight(char[][] input, int x, int y, int x_max, int y_max) {
        if (bottomBoundCheck(x, y, x_max, y_max) && rightBoundCheck(x, y, x_max, y_max)) {
            return input[x + 1][y + 1] == 'M' && input[x + 2][y + 2] == 'A' && input[x + 3][y + 3] == 'S';
        }
        return false;
    }

    boolean toTop(char[][] input, int x, int y, int x_max, int y_max) {
        if (topBoundCheck(x, y, x_max, y_max)) {
            return input[x][y - 1] == 'M' && input[x][y - 2] == 'A' && input[x][y - 3] == 'S';
        }
        return false;
    }

    boolean toLeft(char[][] input, int x, int y, int x_max, int y_max) {
        if (leftBoundCheck(x, y, x_max, y_max)) {
            return input[x - 1][y] == 'M' && input[x - 2][y] == 'A' && input[x - 3][y] == 'S';
        }
        return false;
    }

    boolean toRight(char[][] input, int x, int y, int x_max, int y_max) {
        if (rightBoundCheck(x, y, x_max, y_max)) {
            return input[x + 1][y] == 'M' && input[x + 2][y] == 'A' && input[x + 3][y] == 'S';
        }
        return false;
    }

    boolean toBottom(char[][] input, int x, int y, int x_max, int y_max) {
        if (bottomBoundCheck(x, y, x_max, y_max)) {
            return input[x][y + 1] == 'M' && input[x][y + 2] == 'A' && input[x][y + 3] == 'S';
        }
        return false;
    }

    boolean topBoundCheck(int x, int y, int x_max, int y_max) {
        return y > 2;
    }

    boolean leftBoundCheck(int x, int y, int x_max, int y_max) {
        return x > 2;
    }

    boolean rightBoundCheck(int x, int y, int x_max, int y_max) {
        return x < x_max - 3;
    }

    boolean bottomBoundCheck(int x, int y, int x_max, int y_max) {
        return y < y_max - 3;
    }
}
