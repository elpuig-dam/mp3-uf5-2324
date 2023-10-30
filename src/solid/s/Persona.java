package solid.s;

public class Persona {
    private String Nom;
    private short Edat;

    public Persona(String Nom, short Edat) {
        this.Nom = Nom;
        this.Edat = Edat;
    }

    public String getNom() {
        return Nom;
    }

    public short getEdat() {
        return Edat;
    }

}
