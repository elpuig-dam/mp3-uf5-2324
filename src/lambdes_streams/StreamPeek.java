package lambdes_streams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPeek {

    public static void main(String[] args) {

        Stream<String> myStream = Stream.of("Pep", "Jordi", "Jonathan", "Pedro", "Nicolás", "María", "Juan", "Ana");
        var names = myStream.peek( n -> System.out.printf("STEP 1: %s %n", n))
                            .filter(n -> n.length() > 3)
                            .peek( n -> System.out.printf("STEP 2: %s %n", n))
                            .filter( n -> n.contains("o"))
                            .peek( n -> System.out.printf("STEP 3: %s %n", n))
                            .map( n -> n.toUpperCase())
                            .peek( n -> System.out.printf("STEP 4: %s %n", n))
                            .collect(Collectors.toList());

        System.out.println("-------------------------------------------------------------------------------------------------------");

        Stream<String> words = Stream.of("hola","que" ,"tal", "estas","tu");
        words.filter(w->w.length() > 3).map(w->w.toUpperCase()).forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------------------------------------------");

        words = Stream.of("hola","que" ,"tal", "estas","tu");
        words.filter(w->w.length() > 3).peek(System.out::println).map(w->w.toUpperCase()).peek(System.out::println).forEach(System.out::println);

        System.out.println("-------------------------------------------------------------------------------------------------------");

        Stream.of("ace", "jack", "queen", "king", "joker")
                .mapToInt(card -> card.length())
                .filter(len -> len > 3)
                .peek(System.out::println)
                .forEach( l -> System.out.println(l));

        System.out.println("-------------------------------------------------------------------------------------------------------");


        Stream.of("hola","que" ,"tal", "estas","tu")
                .peek((w)-> {
                    System.out.println("***inicio****");
                    System.out.println(w);
                    System.out.println("****fin inicio****");
                }).filter((w)->w.length()>3)
                .peek((w)-> {
                    System.out.println("-----filtro--------");
                    System.out.println(w);
                    System.out.println("-----fin filtro-----");


                })
                .map((w)->w.toUpperCase()).
                peek((w)-> {
                    System.out.println(">>>>>>mayusculas>>>>");
                    System.out.println(w);
                    System.out.println(">>>>>fin mayusculas>>>>");


                }).forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------------------------");

        int[][] iaa = { {1, 2}, {3, 4}, { 5, 6} };
        long count = Stream.of(iaa).flatMapToInt(IntStream::of)
                .peek(System.out::println)
                .map(i->i+1)
                .peek(System.out::println)
                .filter(i->i%2 != 0)
                .peek(System.out::println)
                .count();
        System.out.println(count);


    }
}
