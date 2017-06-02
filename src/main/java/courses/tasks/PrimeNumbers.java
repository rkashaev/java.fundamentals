package courses.tasks;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class PrimeNumbers {

    static List<Integer> byEratosthenes(int max) {
        BitSet bs = new BitSet(max + 1);
        bs.set(1, max, true);

        for (int i = 2; i < Math.sqrt(max); i = bs.nextSetBit(i + 1)) {
            if (i < 0) break;
            for (int j = i + i; j < max + 1; j += i) {
                bs.clear(j);
            }
        }

        List<Integer> res = new ArrayList<>(bs.cardinality());
        for (int i = 1; i < max; i = bs.nextSetBit(i + 1)) {
            if (i < 0) break;
//            res.add(i);
            System.out.println(i);
        }
        return res;
    }

    public static void main(String[] args) {
        byEratosthenes(10_000_000);
//        System.out.println(list);
    }
}
