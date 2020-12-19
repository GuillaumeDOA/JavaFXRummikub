package rummikub;

public class Steentje implements Comparable<Steentje> {
    private int waarde;
    private SteenColor kleur;

    public Steentje(int waarde, SteenColor kleur) {
        this.waarde = waarde;
        this.kleur = kleur;
    }

    public int getWaarde() {
        return waarde;
    }

    public SteenColor getColor() {
        return kleur;
    }

    @Override
    public String toString() {
        return kleur.toString() + waarde + SteenColor.RESET;
    }

    @Override
    public int compareTo(Steentje anderSteen) {
        return this.getWaarde() - anderSteen.getWaarde();
    }
}

