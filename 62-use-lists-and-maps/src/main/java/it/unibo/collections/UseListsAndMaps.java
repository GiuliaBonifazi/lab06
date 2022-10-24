package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int MAX_ADD = 100_000;
    private static final int MAX_READ = 1000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> tryArrList = new ArrayList<>();
        for (int i = 1000; i < 2000; i++) {
            tryArrList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> tryLinList = new LinkedList<>(tryArrList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int tempElem = tryArrList.get(0);
        tryArrList.set(0 , tryArrList.get(tryArrList.size() - 1));
        tryArrList.set(tryArrList.size() - 1, tempElem);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        System.out.print("|");
        for (final int i : tryArrList) {
            System.out.print(i + "|");
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long timeArray = System.nanoTime();
        for (int i = 0 ; i <= MAX_ADD; i++) {
            tryArrList.add(i);
        }
        timeArray = System.nanoTime() - timeArray;
        long timeLinked = System.nanoTime();
        for (int i = 0 ; i < MAX_ADD; i++) {
            tryLinList.add(0 , i);
        }
        timeLinked = System.nanoTime() - timeLinked;
        System.out.println("\n Adding 100.000 elements" +
                           "\n ArrayList time : " + TimeUnit.NANOSECONDS.toMillis(timeArray) + "ms" +
                           "\nLinkedList time : " + TimeUnit.NANOSECONDS.toMillis(timeLinked) + "ms");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        timeArray = System.nanoTime();
        for (int i = 0; i < MAX_READ ; i++) {
            tryArrList.get(tryArrList.size() / 2);
        }
        timeArray = System.nanoTime() - timeArray;
        timeLinked = System.nanoTime();
        for (int i = 0; i < MAX_READ ; i++) {
            tryLinList.get(tryLinList.size() / 2);
        }
        timeLinked = System.nanoTime() - timeLinked;
        System.out.println("Reading 1000 times an element in central position" +
                           "\n ArrayList time : " + TimeUnit.NANOSECONDS.toMillis(timeArray) + "ms" +
                           "\nLinkedList time : " + TimeUnit.NANOSECONDS.toMillis(timeLinked) + "ms");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> worldMap = new HashMap<>();
        worldMap.put("Africa" , 1_110_635_000L);
        worldMap.put("Americas" , 972_005_000L);
        worldMap.put("Antarctica" , 0L);
        worldMap.put("Asia" , 4_298_723_000L);
        worldMap.put("Europe" , 742_452_000L);
        worldMap.put("Oceania" , 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        final Iterator<Long> valuesIter = worldMap.values().iterator();
        long population = 0;
        while (valuesIter.hasNext()) {
            population += valuesIter.next();
        }
        System.out.println("The world population is " + population);
    }
}
