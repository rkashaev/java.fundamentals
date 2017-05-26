package courses.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordStats {
    private static final java.lang.String DELIMS = "\r\n\t .,-";

    public static void main(String[] args) {
        Map<String, Integer> res = wordStat("/war_and_peace.txt");

        res = sortByValuesAndTrim(res, 10);
//        res = sortByValuesAndTrim(res);

        System.out.println(res);


    }

    private static <K, V extends Comparable<V>> Map<K, V> sortByValuesAndTrim(Map<K, V> map, int count) {

        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (e1, e2) -> (e2.getValue()).compareTo(e1.getValue()));
        Map<K, V> res = new LinkedHashMap<>();
        int i = 0;
        for (Map.Entry<K, V> entry : list) {
            res.put(entry.getKey(), entry.getValue());
            if (++i >= count)
                break;
        }
        return res;
    }

    private static <K, V extends Comparable<V>> Map<K, V> sortByValuesAndTrim(Map<K, V> map) {
        Map<K, V> sortedMap = new TreeMap<>(new ValueComparator(map));
        sortedMap.putAll(map);
        return sortedMap;
    }

    public static Map<String, Integer> wordStat(String filename) {
        final Map<String, Integer> res = new HashMap<>();
        final Pattern wordPattern = Pattern.compile("[a-z]{3,}");

        try (BufferedReader ir = Files.newBufferedReader(getPath(filename))) {
            // reading file
            while (ir.ready()) {
                String str = ir.readLine().toLowerCase();
                // parsing a line
                Matcher matcher = wordPattern.matcher(str);
                while (matcher.find()) {
                    String s = matcher.group();
                    incrementKey(res, s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static Path getPath(String filename) {
        return Paths.get(getUri(filename));
    }

    private static void incrementKey(Map<String, Integer> res, String key) {
        if (res.containsKey(key)) {
            res.put(key, res.get(key) + 1);
        } else {
            res.put(key, 1);
        }
    }

    private static class ValueComparator<K, V extends Comparable<V>> implements Comparator<K> {
        private Map<K, V> map;

        public ValueComparator(Map<K, V> map) {
            this.map = map;
        }

        @Override
        public int compare(K o1, K o2) {
            return map.get(o2).compareTo(map.get(o1));
        }
    }

    private static URI getUri(String filename) {
        try {
            return WordStats.class.getResource(filename).toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

}
