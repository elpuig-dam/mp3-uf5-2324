package lambdes_streams;

import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
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

public class LongStreamDemo {
    
    public static void main(String[] args) {

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("LongStream.of(int... values)");
        System.out.println("------------------------------------------------------------------------------------");
        // The LongStream.of method returns a stream whose elements are specified.
        LongStream longStream1 = LongStream.of(1, 3, 5, 7);
        longStream1.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("LongStream.range(int startInclusive, int endExclusive)");
        System.out.println("------------------------------------------------------------------------------------");
        // LongStream.range returns a sequential LongStream for the range of int elements.
        // LongStream.range first parameter is inclusive while the second is exclusive
        LongStream longStream2 = LongStream.range(1, 10);
        longStream2.forEach(System.out::println);

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("LongStream.rangeClosed(int startInclusive, int endInclusive)");
        System.out.println("------------------------------------------------------------------------------------");
        // The difference between LongStream.range and LongStream.rangeClosed is that the second parameter
        // or end parameter is inclusive instead of exclusive.
        LongStream longStream3 = LongStream.rangeClosed(1, 10);
        longStream3.forEach(System.out::println);


        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Arrays.stream(long[] array)");
        System.out.println("------------------------------------------------------------------------------------");
        LongStream longStream4 = Arrays.stream(new long[]{20, 98, 12, 7, 35});
        longStream4.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Arrays.stream(long[] array, int startInclusive, int endExclusive)");
        System.out.println("------------------------------------------------------------------------------------");
        LongStream longStream5 = Arrays.stream(new long[]{20, 98, 12, 7, 35}, 0, 2);
        longStream5.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("LongStream.iterate(int seed, LongUnaryOperator)");
        System.out.println("------------------------------------------------------------------------------------");
        // LongStream.iterate will return an infinite sequential ordered LongStream.
        // The first parameter to LongStream.iterate is the seed
        LongStream longStream6 = LongStream.iterate(1, v -> v + 1).limit(10);
        longStream6.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("LongStream.generate(LongSupplier)");
        System.out.println("------------------------------------------------------------------------------------");
        //  LongStream.generate allows you to produce an infinite stream of values on demand.
        LongStream longStream7 = LongStream.generate(() -> (long)(Math.random() * 1000)).limit(10).distinct();
        longStream7.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("LongStream.builder(LongSupplier)");
        System.out.println("------------------------------------------------------------------------------------");
        //  LongStream has a builder that allows you to chain together calls to set up configuration followed by a
        //  build method that creates the stream
        LongStream longStream8 = LongStream.builder().add(10).add(5).add(10).add(100).build();
        longStream8.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("LongStream.concat(LongStream, LongStream)");
        System.out.println("------------------------------------------------------------------------------------");
        //  LongStream provides the ability to concat or combine streams together
        LongStream LongStream9 = LongStream.builder().add(10).add(5).add(10).add(100).build();
        LongStream longStream10 = LongStream.builder().add(10).add(5).add(10).add(100).build();
        LongStream longStream11 = LongStream.concat(LongStream9, longStream10);
        longStream11.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("long[] -> List<Long>");
        System.out.println("------------------------------------------------------------------------------------");
        long[] numbers = { 1, 2, 3, 4, 5, 6 };
        Stream<Long> s = Arrays.stream(numbers).boxed();
        List<Long> lNumbers = s.collect(Collectors.toList());
        System.out.println(lNumbers);


        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("List<Long> -> long[]");
        System.out.println("------------------------------------------------------------------------------------");
        LongStream longStream12 =  lNumbers.stream().mapToLong(value -> value.longValue());
        long[] aNumbers = longStream12.toArray();
        System.out.println(Arrays.toString(aNumbers));


        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Generate statistics of LongStream");
        System.out.println("------------------------------------------------------------------------------------");
        LongSummaryStatistics statistics = LongStream.of(1,2,3,4,5,6,7,8,9,10).summaryStatistics();
	    long count = statistics.getCount();
        long min = statistics.getMin();
	    long max = statistics.getMax();
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
