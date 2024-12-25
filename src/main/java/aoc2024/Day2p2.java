package aoc2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day2p2 {
    public static void main(String[] args) throws IOException {
        Day2p2 day2 = new Day2p2();
        List<String> input = Files.readAllLines(Paths.get("src/main/resources/day2/input"));
        day2.parse(input);
    }

    void parse(List<String> input) {
        int safe_count = 0;
        for (String line : input) {
            String[] elm = line.split("\\s+");
            List<Integer> elm_int = new ArrayList<>();
            for (String s : elm) {
                elm_int.add(Integer.parseInt(s));
            }
            if (validate(elm_int.toArray(new Integer[0]))) {
                safe_count++;
            } else {
                for (int j = 0; j < elm_int.size(); j++) {
                    List<Integer> removed_one = new ArrayList<>(elm_int);
                    removed_one.remove(j);
                    if (validate(removed_one.toArray(new Integer[0]))) {
                        safe_count++;
                        break;
                    }
                }
            }
        }
        System.out.println(safe_count);
    }

    boolean validate(Integer[] elms) {
        boolean increasing = elms[0] <= elms[1];
        for (int i = 0; i < elms.length - 1; i++) {
            if (increasing) {
                if (elms[i] > elms[i + 1]) {
                    return false;
                }
            } else {
                if (elms[i] < elms[i + 1]) {
                    return false;
                }
            }
        }

        for (int j = 0; j < elms.length - 1; j++) {
            if (Math.abs(elms[j] - elms[j + 1]) < 1) return false;
            if (Math.abs(elms[j] - elms[j + 1]) > 3) return false;
        }

        return true;
    }


}
