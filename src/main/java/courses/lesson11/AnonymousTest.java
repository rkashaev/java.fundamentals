package courses.lesson11;


import java.util.Arrays;
import java.util.Comparator;

public class AnonymousTest {
    int imEffectivelyFinalHuh = 1;

    public AnonymousTest() {
        imEffectivelyFinalHuh++;
    }

    public void sort() {
        Anonymous[] arr = {
                new Anonymous(),
                new Anonymous(),
        };

        imEffectivelyFinalHuh++;
        int d = 0;
//        d++;

        Arrays.sort(arr, new Comparator<Anonymous>() {
            @Override
            public int compare(Anonymous o1, Anonymous o2) {
                System.out.println(imEffectivelyFinalHuh);
                System.out.println(d);
                System.out.println(this);
                return o1.c - o2.c;
            }

            @Override
            public String toString() {
                return "I'm an anon.class";
            }
        });
        Arrays.sort(arr, (o1, o2) -> {
            System.out.println(imEffectivelyFinalHuh);
            System.out.println(d);
            System.out.println(this);
            return o1.c - o2.c;
        });
    }

    @Override
    public String toString() {
        return "I'm AnonymousTest{}";
    }

    public static void main(String[] args) {

        AnonymousTest main = new AnonymousTest();
        main.sort();

    }

    class Anonymous {
        int c = 0;

        public Anonymous() {
            c = (int) (Math.random() * 10);
        }
    }
}
