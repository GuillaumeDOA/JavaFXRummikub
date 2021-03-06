package rummikub;

public class Steentje implements Comparable<Steentje> {
    private int waarde;
    private SteenColor kleur;
    private boolean joker;

    public Steentje(int waarde, SteenColor kleur) {
        this.waarde = waarde;
        this.kleur = kleur;
        this.joker=false;
    }
    public Steentje(SteenColor kleur, boolean joker){
        this.joker=joker;
        this.waarde=0;
        this.kleur=kleur;
    }

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

    public boolean isJoker() {
        return joker;
    }

    public SteenColor getColor() {
        return kleur;
    }

    @Override
    public String toString() {
        return kleur.toString() + (joker ? "0" : waarde) + SteenColor.RESET;
    }

    @Override
    public int compareTo(Steentje anderSteen) {
        return this.getWaarde() - anderSteen.getWaarde();
    }
}

