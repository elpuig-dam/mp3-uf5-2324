package lambdes_streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// -----------------------------------------------------------------------------------------------------------
// Primitive Streams
// -----------------------------------------------------------------------------------------------------------
// Streams primarily work with collections of objects and not primitive types.
//
// Fortunately, to provide a way to work with the three most used primitive types – int, long and double – 
// the standard library includes three primitive-specialized implementations: IntStream, LongStream, and DoubleStream.
//
// Primitive streams are limited mainly because of boxing overhead and because creating specialized streams for other 
// primitives isn't' that useful in many cases.

public class IntStreamDemo {
    
    public static void main(String[] args) {
        
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("IntStream.of(int... values)");
        System.out.println("------------------------------------------------------------------------------------");
        // The IntStream.of method returns a stream whose elements are specified.
        IntStream intStream1 = IntStream.of(1, 3, 5, 7);
        intStream1.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("IntStream.range(int startInclusive, int endExclusive)");
        System.out.println("------------------------------------------------------------------------------------");
        // IntStream.range returns a sequential IntStream for the range of int elements.
        // IntStream.range first parameter is inclusive while the second is exclusive
        IntStream intStream2 = IntStream.range(1, 10);
        intStream2.forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("IntStream.rangeClosed(int startInclusive, int endInclusive)");
        System.out.println("------------------------------------------------------------------------------------");
        // The difference between IntStream.range and IntStream.rangeClosed is that the second parameter
        // or end parameter is inclusive instead of exclusive.
        IntStream intStream3 = IntStream.rangeClosed(1, 10);
        intStream3.forEach(System.out::println);


        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Arrays.stream(int[] array)");
        System.out.println("------------------------------------------------------------------------------------");
        IntStream intStream4 = Arrays.stream(new int[]{20, 98, 12, 7, 35});
        intStream4.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Arrays.stream(int[] array, int startInclusive, int endExclusive)");
        System.out.println("------------------------------------------------------------------------------------");
        IntStream intStream5 = Arrays.stream(new int[]{20, 98, 12, 7, 35}, 0, 2);
        intStream5.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("IntStream.iterate(int seed, IntUnaryOperator)");
        System.out.println("------------------------------------------------------------------------------------");
        // IntStream.iterate will return an infinite sequential ordered IntStream.
        // The first parameter to IntStream.iterate is the seed
        IntStream intStream6 = IntStream.iterate(1, v -> v + 1).limit(10);
        intStream6.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("IntStream.generate(IntSupplier)");
        System.out.println("------------------------------------------------------------------------------------");
        //  IntStream.generate allows you to produce an infinite stream of values on demand.
        IntStream intStream7 = IntStream.generate(() -> (int)(Math.random() * 1000)).limit(10).distinct();
        intStream7.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("IntStream.builder(IntSupplier)");
        System.out.println("------------------------------------------------------------------------------------");
        //  IntStream has a builder that allows you to chain together calls to set up configuration followed by a
        //  build method that creates the stream
        IntStream intStream8 = IntStream.builder().add(10).add(5).add(10).add(100).build();
        intStream8.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("IntStream.concat(IntStream, IntStream)");
        System.out.println("------------------------------------------------------------------------------------");
        //  IntStream provides the ability to concat or combine streams together
        IntStream intStream9 = IntStream.builder().add(10).add(5).add(10).add(100).build();
        IntStream intStream10 = IntStream.builder().add(10).add(5).add(10).add(100).build();
        IntStream intStream11 = IntStream.concat(intStream9, intStream10);
        intStream11.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("int[] -> List<Integer>");
        System.out.println("------------------------------------------------------------------------------------");
        int[] numbers = { 1, 2, 3, 4, 5, 6 };
        Stream<Integer> s = Arrays.stream(numbers).boxed();
        List<Integer> lNumbers = s.collect(Collectors.toList());
        System.out.println(lNumbers);


        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("List<Integer> -> int[]");
        System.out.println("------------------------------------------------------------------------------------");
        IntStream intStream12 =  lNumbers.stream().mapToInt(value -> value.intValue());
        int[] aNumbers = intStream12.toArray();
        System.out.println(Arrays.toString(aNumbers));

        System.out.println("------------------------------------------------------------------------------------");

        long lCount = IntStream.of(20, 98, 12, 7, 35).count();
        int iCount = IntStream.of(20, 98, 12, 7, 35).sum();
       
        OptionalInt oiMax = IntStream.of(20, 98, 12, 7, 35).max();
        OptionalInt oiMin = IntStream.of(20, 98, 12, 7, 35).min();
        OptionalDouble oiAvg = IntStream.of(20, 98, 12, 7, 35).average();


        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Generate statistics of int stream");
        System.out.println("------------------------------------------------------------------------------------");
        IntSummaryStatistics statistics = IntStream.of(1,2,3,4,5,6,7,8,9,10).summaryStatistics();
        long count = statistics.getCount();
        int min = statistics.getMin();
        int max = statistics.getMax();
        long sum = statistics.getSum();
        double avg = statistics.getAverage();
        System.out.printf("Count: %d %n", count);
        System.out.printf("Min: %d %n", min);
        System.out.printf("Max: %d %n", max);
        System.out.printf("Sum: %d %n", sum);
        System.out.printf("Average: %.2f %n", avg);

        System.out.println("------------------------------------------------------------------------------------");



    }
}
