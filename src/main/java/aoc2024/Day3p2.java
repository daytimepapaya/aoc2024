package aoc2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3p2 {
    public static void main(String[] args) throws IOException {
        Day3p2 day3 = new Day3p2();
        String input = Files.readString(Paths.get("src/main/resources/day3/input"));
        day3.parse(input);
    }

    void parse(String input) {
        int total = 0;
        boolean enable = true;
        Pattern p = Pattern.compile("mul\\((?<left>\\d{1,3}+),(?<right>\\d{1,3}+)\\)|(?<do>do\\(\\))|(?<dont>don't\\(\\))");
        Matcher m = p.matcher(input);
        while (m.find()) {
            if (m.group("do") != null) {
                enable = true;
                continue;
            }
            if (m.group("dont") != null) {
                enable = false;
                continue;
            }
            if (enable) {
                int left = Integer.parseInt(m.group("left"));
                int right = Integer.parseInt(m.group("right"));
                total += left * right;
            }
        }
        System.out.println(total);
    }
}
