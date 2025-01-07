package aoc2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day5 {
    List<Order> pageOrderingRules = new ArrayList<>();
    List<Update> updates = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Day5 day5 = new Day5();
        List<String> input = Files.readAllLines(Paths.get("src/main/resources/day5/input"));
        day5.parse(input);
        day5.count();
    }

    void count() {
        int total = 0;
        for (Update u : updates) {
            if (check(u)) total += getMiddle(u);
        }
    }

    int getMiddle(Update u) {
        return u.pages[(u.pages.length - 1) / 2];
    }

    boolean check(Update u) {
        for (int page : u.pages) {

        }
        return true;
    }

    void parse(List<String> input) {
        boolean isUpdate = false;
        for (String line : input) {
            if (line.isBlank()) {
                isUpdate = true;
                continue;
            }
            if (isUpdate) {
                String[] pages_string = line.split(",");
                int[] pages = new int[pages_string.length];
                for (int i = 0; i < pages_string.length; i++) {
                    pages[i] = Integer.parseInt(pages_string[i]);
                }
                Update u = new Update(pages);
                updates.add(u);
            } else {
                String[] split = line.split("\\|");
                Order o = new Order(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                pageOrderingRules.add(o);
            }
        }
    }

    record Order(int before, int after) {
    }

    record Update(int[] pages) {
    }
}
