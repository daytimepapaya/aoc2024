package aoc2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day2 {
    public static void main(String[] args) throws IOException {
        Day2 day2 = new Day2();
        List<String> input = Files.readAllLines(Paths.get("src/main/resources/day2/input"));
        day2.parse(input);
    }

    void parse(List<String> input) {
        int safe_count = 0;
        for (String line : input) {
            String[] elm = line.split("\\s+");
            int[] elm_int = new int[elm.length];
            for (int i = 0; i < elm.length; i++) {
                elm_int[i] = Integer.parseInt(elm[i]);
            }
            if (validate(elm_int)) safe_count++;
        }
        System.out.println(safe_count);
    }

    boolean validate(int[] elms) {
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
