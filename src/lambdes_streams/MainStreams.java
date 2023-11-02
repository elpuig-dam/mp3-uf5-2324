package lambdes_streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MainStreams {

    public static void main(String[] args) {

        Stream<String> stream1 = Stream.of("Joel Capel","Eric","Manel","Franklin","Joel Ramirez","Bryan","Pol", "Adrián");

        String llistaN[] = new String[]{"Joel Capel","Eric","Manel","Franklin","Joel Ramirez","Bryan","Pol", "Adrián"};
        Stream<String> stream2 = Arrays.stream(llistaN);

        List<String> llistaN2 = Arrays.asList(llistaN);
        Stream<String> stream3 = llistaN2.stream();

        stream1.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 4;
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("------------------------------------------");

        stream2.filter(s -> s.length() > 4 )
                .map(String::toUpperCase)
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);



        //stream no són reutilitzables

       // stream2.forEach(System.out::println);


    }
}
