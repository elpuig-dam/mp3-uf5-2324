package lambdes_streams;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
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

public class DoubleStreamDemo {
    
    public static void main(String[] args) {

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("DoubleStream.of(int... values)");
        System.out.println("------------------------------------------------------------------------------------");
        // The DoubleStream.of method returns a stream whose elements are specified.
        DoubleStream doubleStream1 = DoubleStream.of(1, 3, 5, 7);
        doubleStream1.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Arrays.stream(double[] array)");
        System.out.println("------------------------------------------------------------------------------------");
        DoubleStream doubleStream2 = Arrays.stream(new double[]{20, 98, 12, 7, 35});
        doubleStream2.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Arrays.stream(double[] array, int startInclusive, int endExclusive)");
        System.out.println("------------------------------------------------------------------------------------");
        DoubleStream doubleStream3 = Arrays.stream(new double[]{20, 98, 12, 7, 35}, 0, 2);
        doubleStream3.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("DoubleStream.iterate(int seed, DoubleUnaryOperator)");
        System.out.println("------------------------------------------------------------------------------------");
        // DoubleStream.iterate will return an infinite sequential ordered DoubleStream.
        // The first parameter to DoubleStream.iterate is the seed
        DoubleStream doubleStream4 = DoubleStream.iterate(1, v -> v + 1).limit(10);
        doubleStream4.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("DoubleStream.generate(DoubleSupplier)");
        System.out.println("------------------------------------------------------------------------------------");
        //  Double.generate allows you to produce an infinite stream of values on demand.
        DoubleStream doubleStream5 = DoubleStream.generate(() -> Math.random() * 1000).limit(10).distinct();
        doubleStream5.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("DoubleStream.builder(DoubleSupplier)");
        System.out.println("------------------------------------------------------------------------------------");
        //  DoubleStream has a builder that allows you to chain together calls to set up configuration followed by a
        //  build method that creates the stream
        DoubleStream doubleStream6 = DoubleStream.builder().add(10).add(5).add(10).add(100).build();
        doubleStream6.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("DoubleStream.concat(DoubleStream, DoubleStream)");
        System.out.println("------------------------------------------------------------------------------------");
        //  Double provides the ability to concat or combine streams together
        DoubleStream doubleStream7 = DoubleStream.builder().add(10).add(5).add(10).add(100).build();
        DoubleStream doubleStream8 = DoubleStream.builder().add(10).add(5).add(10).add(100).build();
        DoubleStream doubleStream9 = DoubleStream.concat(doubleStream7, doubleStream8);
        doubleStream9.forEach(v -> System.out.println(v));

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("double[] -> List<Double>");
        System.out.println("------------------------------------------------------------------------------------");
        double[] numbers = { 1, 2, 3, 4, 5, 6 };
        Stream<Double> s = Arrays.stream(numbers).boxed();
        List<Double> lNumbers = s.collect(Collectors.toList());
        System.out.println(lNumbers);


        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("List<Double> -> double[]");
        System.out.println("------------------------------------------------------------------------------------");
        DoubleStream doubleStream10 =  lNumbers.stream().mapToDouble(value -> value.doubleValue());
        double[] aNumbers = doubleStream10.toArray();
        System.out.println(Arrays.toString(aNumbers));


        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Generate statistics of DoubleStream");
        System.out.println("------------------------------------------------------------------------------------");
        DoubleSummaryStatistics statistics = DoubleStream.of(1,2,3,4,5,6,7,8,9,10).summaryStatistics();
        long count = statistics.getCount();
        double min = statistics.getMin();
        double max = statistics.getMax();
        double sum = statistics.getSum();
        double avg = statistics.getAverage();
        System.out.printf("Count: %d %n", count);
        System.out.printf("Min: %d %n", min);
        System.out.printf("Max: %d %n", max);
        System.out.printf("Sum: %d %n", sum);
        System.out.printf("Average: %.2f %n", avg);

        System.out.println("------------------------------------------------------------------------------------");


        
    }
}
