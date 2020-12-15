package rummikub;

public class Steentje {
    private int waarde;
    private String kleur;

    public Steentje(int waarde, String kleur) {
        this.waarde = waarde;
        this.kleur = kleur;
    }

    public int getWaarde() {
        return waarde;
    }

    public String getColor() {
        return kleur;
    }

    @Override
    public String toString() {
        return kleur + waarde + ConsoleColor.RESET;
    }
}
