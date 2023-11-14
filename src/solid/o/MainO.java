package solid.o;

public class MainO {

    public static void main(String[] args) {
        Treballador treb1 = new TreballadorFix("Jason", "Lee", 2000, true);
        Treballador treb2 = new TreballadorTemp("Jana", "Lowes", 2000, false);

        System.out.println(treb1 + "Bonus: " + treb1.CalcularBonus());
        System.out.println(treb2 + "Bonus: " + treb2.CalcularBonus());
    }
}
