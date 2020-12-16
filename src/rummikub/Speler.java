package rummikub;

import java.util.Collections;
import java.util.Comparator;

public class Speler {

    private Hand bord;

    public Speler() {
        bord = new Hand();
    }

    public void PrintHand() {
        bord.PrintHand();
    }

    public void SorteerKleur() {
        Collections.sort(bord.getHand(), new Comparator<Steentje>() {
            @Override
            public int compare(Steentje o1, Steentje o2) {
                return o1.getWaarde() - o2.getWaarde();
            }
        });
        Collections.sort(bord.getHand(), new Comparator<Steentje>() {
            @Override
            public int compare(Steentje o1, Steentje o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });
    }

    public void SorteerGetal() {
        Collections.sort(bord.getHand(), new Comparator<Steentje>() {
            @Override
            public int compare(Steentje o1, Steentje o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });
        Collections.sort(bord.getHand(), new Comparator<Steentje>() {
            @Override
            public int compare(Steentje o1, Steentje o2) {
                return o1.getWaarde() - o2.getWaarde();
            }
        });
    }

    public void addSteentje(Steentje steen) {
        bord.getHand().add(steen);
    }

}
