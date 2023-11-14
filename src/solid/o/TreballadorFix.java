package solid.o;

public class TreballadorFix extends Treballador {

    public TreballadorFix(String nom, String cognom, float salari, boolean casat) {
        super(nom, cognom, salari, casat);
    }

    @Override
    public float CalcularBonus() {
        return getSalari() * 0.1f;
    }
}
