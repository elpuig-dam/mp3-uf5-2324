package lambdes_streams;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Alumne implements Comparable<Alumne>{
    private LocalDate dataNaixament;
    private String nom;

    public Alumne(LocalDate dataNaixament, String nom) {
        this.dataNaixament = dataNaixament;
        this.nom = nom;
    }

    public Alumne(String nom) {
        this.nom = nom;
    }

    public LocalDate getDataNaixament() {
        return dataNaixament;
    }

    public void setDataNaixament(LocalDate dataNaixament) {
        this.dataNaixament = dataNaixament;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Alumne{" +
                "dataNaixament=" + dataNaixament +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public int compareTo(Alumne o) {
        if(dataNaixament.isBefore(o.getDataNaixament())) return -1;
        else if(dataNaixament.isAfter(o.getDataNaixament())) return 1;
        else return 0;
    }


    public static void main(String[] args) throws InterruptedException {
        Alumne a1 = new Alumne(LocalDate.of(1990,5,20),"Rubén");
        Alumne a2 = new Alumne(LocalDate.of(1994,6,2),"Raimón");
        Alumne a3 = new Alumne(LocalDate.of(1980,1,1),"Kevin");

        List<Alumne> llistaAlumnes = Arrays.asList(a1,a2,a3);

        llistaAlumnes.forEach(new Consumer<Alumne>() {
            @Override
            public void accept(Alumne alumne) {
                System.out.println(alumne);
            }
        });

        llistaAlumnes.forEach((Alumne a) -> { System.out.println(a);});
        llistaAlumnes.forEach(System.out::println);

        Collections.sort(llistaAlumnes);
        llistaAlumnes.forEach(a -> System.out.println(a));
        System.out.println("------------------------------------------");
        /*Collections.sort(llistaAlumnes, new Comparator<lambdas.exemples.Alumne>() {
            @Override
            public int compare(lambdas.exemples.Alumne o1, lambdas.exemples.Alumne o2) {
               return o1.getNom().compareTo(o2.getNom());
            }
        });*/


        Collections.sort(llistaAlumnes,(o1,o2) -> o1.getNom().compareTo(o2.getNom()));
        llistaAlumnes.forEach(a -> System.out.println(a));


        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hola sóc un procés");
            }
        };

        Runnable r2 = () ->  System.out.println("Hola sóc el procés 2");
        r2.run();

        Thread th = new Thread(() -> System.out.println("soc el thread"));
        th.start();
        th.join();

        System.out.println("fi");


        long c = llistaAlumnes.stream().filter(alumne -> alumne.getDataNaixament().getYear()<1995)
                .count();
        System.out.println(c);

    }


}
