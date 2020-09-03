package patterns.factory;

public class Auto extends Prodotto {

    private int cilindrata;

    public void guida() {
        System.out.println("Guida la macchina");
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

}
