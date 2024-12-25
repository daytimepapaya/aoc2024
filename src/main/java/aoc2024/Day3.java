package aoc2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    public static void main(String[] args) throws IOException {
        Day3 day3 = new Day3();
        String input = Files.readString(Paths.get("src/main/resources/day3/input"));
        day3.parse(input);
    }

    void parse(String input) {
        int total = 0;
        Pattern p = Pattern.compile("mul\\((\\d{1,3}+),(\\d{1,3}+)\\)");
        Matcher m = p.matcher(input);
        while (m.find()) {
            int left = Integer.parseInt(m.group(1));
            int right = Integer.parseInt(m.group(2));
            total += left * right;
        }
        System.out.println(total);
    }
}
