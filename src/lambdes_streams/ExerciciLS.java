package lambdes_streams;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExerciciLS {

    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/yyy");
        Persona p1 = new Persona("Arya", Persona.Genere.DONA, LocalDate.parse("25/12/2002",format) );
        Persona p2 = new Persona("Tyrion", Persona.Genere.HOME, LocalDate.parse("12/10/1980",format));
        Persona p3 = new Persona("Cersei", Persona.Genere.DONA, LocalDate.parse("10/01/1984",format));
        Persona p4 = new Persona("Eddard", Persona.Genere.HOME, LocalDate.parse("24/04/1974",format));
        Persona p5 = new Persona("Sansa", Persona.Genere.DONA, LocalDate.parse("24/04/1992",format));
        Persona p6 = new Persona("Jaime", Persona.Genere.HOME, LocalDate.parse("24/04/1979",format));
        Persona p7 = new Persona("Khal", Persona.Genere.HOME, LocalDate.parse("10/08/1979",format));
        Persona p8 = new Persona("Daenerys", Persona.Genere.DONA, LocalDate.parse("12/11/1992",format));
        Persona p9 = new Persona("Davos", Persona.Genere.HOME, LocalDate.parse("12/11/1965",format));
        Persona p10 = new Persona("Jon Neu", Persona.Genere.HOME, LocalDate.parse("12/11/1986",format));
        Persona p11 = new Persona("Brienne", Persona.Genere.DONA, LocalDate.parse("12/11/1989",format));

        Persona[] lpers = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11};
        List<Persona> llistaPersones;
        llistaPersones = new ArrayList<>(Arrays.asList(lpers));
        Map<Integer,Integer> mapPersones = new HashMap<>();

        // 1 - Canviar a lambda
        System.out.println("\n1-2");
        Collections.sort(llistaPersones, new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                if(o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
                else return -1;
            }
        });

        Collections.sort(llistaPersones,
                (o1, o2) -> {
                    if(o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
                    else return -1;
                });

        // 2 - Canviar a Lambda
        for(Persona p: llistaPersones) {
            System.out.println(p);
        }

        llistaPersones.forEach(persona -> System.out.println(persona));

        // 3 - Canvia a classe anònima
        System.out.println("\n3-4");
        //ordenació alfabètica inversa del nom
            llistaPersones.sort((o1,o2) -> o2.getNom().compareTo(o1.getNom()));

        llistaPersones.sort(new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                return o2.getNom().compareTo(o1.getNom());
            }
        });


        // 4 - Canvia per una crida al mètode per referència
        for(Persona p: llistaPersones) {
            System.out.println(p);
        };

        llistaPersones.forEach(System.out::println);


        // 5 - Omplir map. Canviar per un forEach amb lambda
        for(Persona per : llistaPersones) {
            mapPersones.put(per.getAge(),1);
        }

        llistaPersones.forEach(persona -> mapPersones.put(persona.getAge(),1));

        // 6 - Canvia per un recorregut forEach amb lambda
        System.out.println("\n5");
        for(Map.Entry entry : mapPersones.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        mapPersones.forEach((k,v)-> System.out.println(k + " : " + v));



        /* 7 -
            Esbrina com s'utilitzen els mètodes de map següents
                map.putIfAbsent
                map.computeIfAbsent
                map.computeIfPresent

             per tal d'afegir correctament la feqüència d'edat de les persones.

             Si vols fes-ho primer sense els mètodes anomenats i sense lambdes
             i després amb els mètodes i amb lambdes

             Exemple de sortida:
                34 anys -> 1
                38 anys -> 1
                39 anys -> 2
                26 anys -> 2
                44 anys -> 1
                15 anys -> 1

         */
         /*   for(Persona per : llistaPersones) {
            if(!mapPersones.containsKey(per.getAge())) {
                mapPersones.put(per.getAge(), 1);
            } else {
                mapPersones.put(per.getAge(), mapPersones.get(per.getAge())+1);
            }
        }*/
        /*
           llistaPersones.forEach(persona -> {
               if ((!mapPersones.containsKey(persona.getAge())))
                   mapPersones.put(persona.getAge(), 1);
               else mapPersones.put(persona.getAge(), mapPersones.get(persona.getAge()) + 1);
           });
        */

        llistaPersones.forEach(persona -> {
            mapPersones.computeIfPresent(persona.getAge(),(k,v) -> v + 1);
            mapPersones.putIfAbsent(persona.getAge(),1);

        });


        // 8 - llistat de persones DONA amb lambda (stream)
        System.out.println("\n8 DONES");
        llistaPersones.stream().filter(persona -> persona.getGenere().equals(Persona.Genere.DONA)).forEach(System.out::println);


        // 9 - Llistat dels dos HOMES més joves (stream)
        System.out.println("\n9 HOMES + JOVES");
        llistaPersones.stream()
                .filter(persona -> persona.getGenere().equals(Persona.Genere.HOME))
                .sorted(Comparator.comparing(Persona::getAge))
                .limit(2)
                .forEach(System.out::println);

        // 10- Esborrar (no filtrar o imprimir) del llistat les persones entre 30 i 40 anys (amb lambda)

        System.out.println("\n10");
        List<Persona> novallista = new ArrayList<>();
        llistaPersones.removeIf(persona -> persona.getAge()>30 && persona.getAge()<=40);
        llistaPersones.forEach(System.out::println);

        // 11 - Persones que tinguin una 'a' al seu nom
        System.out.println("\n11 Amb una 'A'");
        llistaPersones.stream().filter(p -> p.getNom().toUpperCase().contains("A")).forEach(System.out::println);


        //12 - Llistat de les dates de naixament + dos dies
        System.out.println("\n12 - dates amb dos dies més");
        llistaPersones.stream().map(persona -> persona.getDataNaixament().plusDays(2)).forEach(System.out::println);


        //13 - Rejovenir dos anys a totes les persones
        System.out.println("\n13 - Rejovenir dos anys a totes les persones");
        llistaPersones.stream().
                map(persona -> {
                    persona.setDataNaixament(persona.getDataNaixament().plusYears(2));
                    return persona;
                })
                .forEach(System.out::println);

        //14. A partir de la següent llista de noms d'alumnes crea una nova llista d'alumnes amb aquest alumnes nous
        // pots modificar la classe alumne si cal.
        System.out.println("\n14 - Alumnes nous a partir de noms de la llista");
        List<String> alumnesNous = Arrays.asList("Pedro","Pablo","Bilma");
        List<Alumne> nous = alumnesNous.stream().map(Alumne::new).toList();
        System.out.println("Alumnes nous");
        nous.forEach(System.out::println);

        //Creem cotxes i els assignem a les diferents persones
        Cotxe c1 = new Cotxe("Seat Ibiza");
        Cotxe c2 = new Cotxe("Seat Leon");
        Cotxe c3 = new Cotxe("Seat Arona");
        Cotxe c4 = new Cotxe("Toyota Auris");
        Cotxe c5 = new Cotxe("Toyota Corolla");
        Cotxe c6 = new Cotxe("Toyota Yaris");
        p1.setCotxe(c1); p2.setCotxe(c2);
        p3.setCotxe(c1); p4.setCotxe(c3);
        p5.setCotxe(c4); p6.setCotxe(c4);
        p7.setCotxe(c5); p8.setCotxe(c6);
        p9.setCotxe(c5); p10.setCotxe(c3);
        p11.setCotxe(c2);
        //15. Crear una llista de persones amb el coxes de la marca Seat i una altra
        // amb les persones que tenen un Toyota. Fes servir streams
        // imprimeix les dues llistes per ordenades per l'edat de les persones
        System.out.println("\n15 - Persones amb Seat i Toyota");
        List<Persona> seats = llistaPersones.stream()
                .filter(persona -> persona.getCotxe().getMarca().contains("Seat"))
                .toList();
        List<Persona> toyotas = llistaPersones.stream()
                .filter(persona -> persona.getCotxe().getMarca().contains("Toyota"))
                .toList();
        System.out.println("SEAT");
        seats.stream()
                .sorted(Comparator.comparing(Persona::getAge))
                .forEach(persona -> System.out.println(persona.getNom() + " " + persona.getAge() + " " + persona.getCotxe().getMarca()));
        System.out.println("TOYOTA");
        toyotas.stream()
                .sorted(Comparator.comparing(Persona::getAge))
                .forEach(persona -> System.out.println(persona.getNom() + " " + persona.getAge() + " " + persona.getCotxe().getMarca()));

        //16. Imprimeix les persones ordenades per ordre alfabètic de la marca dels cotxes
        System.out.println("\n16 - Persones ordenades per ordre alfabètic de la marca dels cotxes");
        llistaPersones.stream()
                .sorted(Comparator.comparing(persona -> persona.getCotxe().getMarca()))
                .forEach(persona -> System.out.println(persona.getNom() + " " + persona.getAge() + " " + persona.getCotxe().getMarca()));


    }


}
