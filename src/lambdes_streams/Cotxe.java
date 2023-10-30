package lambdes_streams;

public class Cotxe {
    String marca;
    public Cotxe(String m) {
        marca = m;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "Cotxe{" +
                "marca='" + marca + '\'' +
                '}';
    }
}