package lambdes_streams;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;


public class DemoStreams {

    public static void main(String[] args) {
        
        List<Player> players = new ArrayList<>();
        players.add(new Player("Maria", "Delgado", 1.98, 85, 20000, LocalDate.of(1985, Month.MARCH, 23)));
        players.add(new Player("Sergio", "Garcia", 1.50, 91, 40000, LocalDate.of(1992, Month.APRIL, 3)));
        players.add(new Player("Pedro", "Sanchez", 1.80, 91, 32000, LocalDate.of(1985, Month.AUGUST, 21)));
        players.add(new Player("Mariano", "Aznar", 1.85, 92, 16000, LocalDate.of(1991, Month.NOVEMBER, 15)));
        players.add(new Player("Laura", "Madrid", 1.75, 75, 35000, LocalDate.of(1985, Month.DECEMBER, 10)));
        players.add(new Player("Vanessa", "Romero", 1.92, 80, 28500, LocalDate.of(1995, Month.SEPTEMBER, 5)));
        players.add(new Player("Jesus", "Quintero", 1.91, 85, 21000, LocalDate.of(1985, Month.OCTOBER, 5)));
        players.add(new Player("Alba", "Garcia", 1.91, 85, 21000, LocalDate.of(1974, Month.JANUARY, 9)));
     
        
        
        System.out.printf("%nInfo sobre la edad de los trabajadores:%n");
        System.out.printf("------------------------------------------%n");
        double avgAge = players.stream()
                              .mapToInt(e -> e.getAge())
                              .average()
                              .getAsDouble();
        int maxAge = players.stream()
                              .mapToInt(e -> e.getAge())
                              .max()
                              .getAsInt();
        int minAge = players.stream()
                              .mapToInt(e -> e.getAge())
                              .min()
                              .getAsInt();
        
        System.out.printf("- Media de edad: %.2f años %n", avgAge);
        System.out.printf("- Máxima edad: %d años %n", maxAge);
        System.out.printf("- Mínima edad: %d años %n", minAge);
        
        System.out.printf("%nInfo sobre la altura de los trabajadores:%n");
        System.out.printf("------------------------------------------%n");
        double avgHeight = players.stream()
                                    .mapToDouble(e -> e.getHeight())
                                    .average()
                                    .getAsDouble();
        double maxHeight = players.stream()
                                    .mapToDouble(e -> e.getHeight())
                                    .max()
                                    .getAsDouble();
        double minHeight = players.stream()
                                    .mapToDouble(e -> e.getHeight())
                                    .min()
                                    .getAsDouble();
        System.out.printf("- Media de altura: %.2f m %n", avgHeight);
        System.out.printf("- Mayor altura: %.2f m %n", maxHeight);
        System.out.printf("- Menor altura: %.2f m %n", minHeight);
       
        System.out.printf("%nInfo sobre el peso de los trabajadores:%n");
        System.out.printf("------------------------------------------%n");
        double avgWeight = players.stream()
                                    .mapToInt(e -> e.getWeight())
                                    .average()
                                    .getAsDouble();
        int maxWeight = players.stream()
                                 .mapToInt(e -> e.getWeight())
                                 .max()
                                 .getAsInt();
        int minWeight = players.stream()
                                 .mapToInt(e -> e.getWeight())
                                 .min()
                                 .getAsInt();
        System.out.printf("- Media de peso: %.2f Kg %n", avgWeight);
        System.out.printf("- Mayor peso: %d kg %n", maxWeight);
        System.out.printf("- Menor peso: %d kg %n", minWeight);
       
        System.out.printf("%nInfo sobre el salario de los trabajadores:%n");
        System.out.printf("------------------------------------------%n");
        double avgSalary = players.stream()
                                    .mapToInt(e -> e.getSalary())
                                    .average()
                                    .getAsDouble();
        int maxSalary = players.stream()
                                 .mapToInt(e -> e.getSalary())
                                 .max()
                                 .getAsInt();
        int minSalary = players.stream()
                                 .mapToInt(e -> e.getSalary())
                                 .min()
                                 .getAsInt();
        int sumSalary = players.stream()
                                 .mapToInt(e -> e.getSalary())
                                 .sum();
        System.out.printf("- Media de salario: %.2f euros %n", avgSalary);
        System.out.printf("- Mayor salario: %d euros %n", maxSalary);
        System.out.printf("- Menor salario: %d euros %n", minSalary);
        System.out.printf("- Suma de salarios: %d euros %n", sumSalary);
        
        System.out.printf("%nInfo sobre los nombres de los trabajadores:%n");
        System.out.printf("-----------------------------------------------%n");
        IntSummaryStatistics letterStats = players.stream()
                                                    .mapToInt(e -> e.getFirstname().length())
                                                    .summaryStatistics();
        
        System.out.printf("- Media de letras nombre: %.2f letras %n", letterStats.getAverage());
        System.out.printf("- Mayor letras en nombre: %d letras %n", letterStats.getMax());
        System.out.printf("- Menor letras en nombre: %d letras %n", letterStats.getMin());
        
       
        System.out.printf("%nTrabajadores más jovenes (entre 18 y 30):%n");
        System.out.printf("------------------------------------------%n");
        List<Player> youngEmployees = players.stream()
                                                 .filter(e -> e.getAge() >= 18 && e.getAge() <= 30)
                                                 .sorted( (e1, e2) -> (e1.getAge() == e2.getAge()) ? 
                                                                                e1.getLastname().compareToIgnoreCase(e2.getLastname()) : 
                                                                                Integer.compare(e1.getAge(), e2.getAge()))
                                                 .collect(Collectors.toList());
        youngEmployees.stream().forEach(e -> System.out.println(e.toString()));
        
        System.out.printf("%nTrabajadores nacidos en meses de verano:%n");
        System.out.printf("------------------------------------------%n");
        List<Player> summerEmployees = players.stream()
                                                 .filter(e -> e.getBirthDate().getMonth() == Month.JUNE || e.getBirthDate().getMonth() == Month.JULY || e.getBirthDate().getMonth() == Month.AUGUST)
                                                 .sorted( (e1, e2) -> (e1.getAge() == e2.getAge()) ? 
                                                                            e1.getLastname().compareToIgnoreCase(e2.getLastname()) : 
                                                                            Integer.compare(e1.getAge(), e2.getAge()))
                                                 .collect(Collectors.toList());
        summerEmployees.stream().forEach(e -> System.out.println(e.toString()));
        
        
        System.out.printf("%nSubir sueldo 1000 euros a todos:%n");
        System.out.printf("------------------------------------------%n");
        players.stream()
                 .forEach(e -> e.setSalary(e.getSalary() + 1000));
        
        players.forEach(e -> System.out.println(e));
        
        
        System.out.printf("%nSubir sueldo 1000 euros a los que cobran menos de 20000:%n");
        System.out.printf("-----------------------------------------------------------%n");
        players.stream()
                 .filter(e -> e.getSalary() < 20000)
                 .forEach(e -> e.setSalary(e.getSalary() + 1000));
        
        
        players.forEach(e -> System.out.println(e));
     
        
    }
}
