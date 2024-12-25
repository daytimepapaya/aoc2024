package aoc2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day1p2 {

    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    List<Pair> pairs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Day1p2 day1 = new Day1p2();
        List<String> input = Files.readAllLines(Paths.get("src/main/resources/day1/input"));
        day1.parse(input);
        day1.calc();
    }

    void parse(List<String> input) {
        for (String line : input) {
            String[] split_line = line.split("\\s+");
            left.add(Integer.parseInt(split_line[0]));
            right.add(Integer.parseInt(split_line[1]));
        }
        left.sort(Integer::compareTo);
        right.sort(Integer::compareTo);

        for (int i = 0; i < left.size(); i++) {
            Pair p = new Pair(left.get(i), right.get(i));
            pairs.add(p);
        }
    }

    void calc() {
        long similarity = 0;
        for (int i : left) {
            similarity += i * right.stream().filter(e -> e == i).count();
        }
        System.out.println(similarity);
    }

    record Pair(Integer left, Integer right) {
    }
}
