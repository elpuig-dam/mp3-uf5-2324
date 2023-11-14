package solid.o;

public class TreballadorTemp extends Treballador {

    public TreballadorTemp(String nom, String cognom, float salari, boolean casat) {
        super(nom, cognom, salari, casat);
    }

    @Override
    public float CalcularBonus() {
        return getSalari() * 0.05f;
    }
}
