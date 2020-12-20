package rummikub;

import java.util.LinkedList;
import java.util.List;

public class Tafel {
    private List<List<Steentje>> gelegedeRijen;

    public Tafel() {
        gelegedeRijen = new LinkedList<>();
    }

    public List<List<Steentje>> getGelegedeRijen() {
        return gelegedeRijen;
    }

    public void printTafel() {
        if (gelegedeRijen.size() == 0) System.out.println("Nog geen Stenen op tafel");
        else {
            int i = 1;
            for (List<Steentje> steentjes : gelegedeRijen) {
                System.out.print(i + ") ");
                for (Steentje steentje : steentjes) {
                    System.out.print(steentje + " ");
                }
                System.out.println("");
                i++;
            }
        }
    }

    public void addSteen(Steentje steen, int rij) {
        gelegedeRijen.get(--rij).add(steen);
    }

    public void addSteen(List<Steentje> stenen) {
        gelegedeRijen.add(stenen);
    }
}
