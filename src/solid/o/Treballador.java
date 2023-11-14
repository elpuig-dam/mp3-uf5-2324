package solid.o;

/**
 * Exemple per explicar Open/Close Principle
 * Tenim la class Treballador i necessitem diferenciar entre treballador fix o temporal
 * també necessitem fer el càlcul del bonus que li pertoca segons sigui fix o temporal
 * Si modifiquem la class Treballador i afegim una propietat tipus i un mètode per a cada tipus
 * estem violant aquest principi.
 * Tancat a modificar però Obert a extendre
 * Per tant cal crear un mètode abstracte CalcularBonus
 * I per crear un treballador fix tenir una nova classe que s'extengui de Treballador i que obligui
 * a implementar com serà el càlcul del seu bonus. Igualment amb el treballador temporal.
 */
public abstract class Treballador {
    private String nom;
    private String cognom;
    private float salari;
    private boolean casat;

    public Treballador(String nom, String cognom, float salari, boolean casat) {
        this.nom = nom;
        this.cognom = cognom;
        this.salari = salari;
        this.casat = casat;
    }

    public abstract float CalcularBonus();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public float getSalari() {
        return salari;
    }

    public void setSalari(float salari) {
        this.salari = salari;
    }

    public boolean isCasat() {
        return casat;
    }

    public void setCasat(boolean casat) {
        this.casat = casat;
    }

    @Override
    public String toString() {
        return nom + "," + cognom + "," + salari + "," + casat;
    }
}
