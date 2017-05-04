package courses.lesson11;

import java.util.*;
import java.util.stream.Collectors;

public class Java8StreamsVsJava7 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // every even element multiple by 2 and return a new list
        // JAVA 7
        List<Integer> res = new ArrayList<>();
        for (Integer el : list) {
            if (el % 2 == 0) {
                res.add(el * 2);
            }
        }
        Collections.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(res);

        // JAVA 8
        res = list.stream()
                .filter(el -> el % 2 == 0)
                .map(el -> el * 2)
                .sorted((o1, o2) -> o2 - o1)
                .collect(Collectors.toList());
        System.out.println(res);

    }
}
