package courses.tasks;

import java.util.HashMap;
import java.util.Map;

public class CharStats {
    public static void main(String[] args) {
        int[] res = stats("aaaaaaabbbbbbb 12323 cdf df ere,., dfd r");
        writeRes(res);

//        Map<Character, Integer> cm = statsAsMap("aaaaaaabbbbbbb 12323 cdf df ere,., dfd r");
//        System.out.println(cm);
    }

    private static void writeRes(int[] res) {
        for (int i = 0; i < res.length; i++) {
            if (res[i] > 0) {
                char c = (char) ('a' + i);
                System.out.printf("%c -> %d\n", c, res[i]);
            }
        }
    }

    public static int[] stats(String str) {
        int[] counts = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = Character.toLowerCase(str.charAt(i));
            if ('a' <= c && c <= 'z') {
                int idx = c - 'a';
                counts[idx]++;
            }
        }
        return counts;
    }

    public static Map<Character, Integer> statsAsMap(String str) {
        int[] stats = stats(str);

        Map<Character, Integer> res = new HashMap<>();

        for (int i = 0; i < stats.length; i++) {
            if (stats[i] > 0) {
                char c = (char) ('a' + i);
                res.put(c, stats[i]);
            }
        }
        return res;
    }
}
