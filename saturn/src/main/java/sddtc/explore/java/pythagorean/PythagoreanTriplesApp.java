package sddtc.explore.java.pythagorean;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by sddtc on 2017/1/25.
 */
public class PythagoreanTriplesApp {

    public void createPythagoreanTriples(boolean display) {
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1,100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a*a + b*b)}));

        if(display) {
            pythagoreanTriples.limit(10).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));
        }
    }

    public void createPythagoreanTriplesAdvance(boolean display) {
        Stream<double[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                .mapToObj(b -> new double[] {a, b, Math.sqrt(a*a + b*b)})
                .filter(t -> t[2] % 1 == 0));

        if(display) {
            pythagoreanTriples.limit(10).forEach(t -> System.out.println(t[0] + "，" + t[1] + ", " + t[2]));
        }
    }

    public static void main(String[] args) {
        PythagoreanTriplesApp app = new PythagoreanTriplesApp();

        long start = System.currentTimeMillis();
        for(int i=0;i<10000;i++) {
            app.createPythagoreanTriples(false);
        }

        System.out.println("cost: " + (System.currentTimeMillis() - start));

        System.out.println("---------");
        start = System.currentTimeMillis();

        for(int j=0;j<10000;j++) {
            app.createPythagoreanTriplesAdvance(false);
        }

        System.out.println("cost: " + (System.currentTimeMillis() - start));
    }
}
