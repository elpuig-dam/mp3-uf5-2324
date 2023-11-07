package exceptions;

import java.time.LocalDate;
import java.time.Period;

public class Person  {
    public enum Genere {
        HOME,DONA
    }
    public final String MSG_ERROR_DATA = "La data de naixament no potser posterior a la data d'avui";
    private String nom;
    private Genere genere;
    private LocalDate dataNaixament;


    public Person(String nom, Genere genere, LocalDate dataNaixament) throws PersonNotBornException {
        this.nom = nom;
        this.genere = genere;
        if(dataNaixament.isAfter(LocalDate.now())) {
            throw new PersonNotBornException(MSG_ERROR_DATA);
        } else {
            this.dataNaixament = dataNaixament;
            System.out.printf("Persona amb una edat de %d anys, creada correctament", getAge());
        }
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Genere getGenere() {
        return genere;
    }
    public void setGenere(Genere genere) {
        this.genere = genere;
    }
    public LocalDate getDataNaixament() {
        return dataNaixament;
    }
    public void setDataNaixament(LocalDate dataNaixament) throws PersonNotBornException {
        if(dataNaixament.isBefore(LocalDate.now()))this.dataNaixament = dataNaixament;
        else new PersonNotBornException(MSG_ERROR_DATA);
    }

    /*
     *	@return int Edat de la persona a partir de la data de naixament
     */
    public int getAge() {
        LocalDate today = LocalDate.now();
        if ((dataNaixament != null) && (today != null)) {
            return Period.between(dataNaixament, today).getYears();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return nom + '\t' + genere.toString() + '\t' + getAge();
    }


}
