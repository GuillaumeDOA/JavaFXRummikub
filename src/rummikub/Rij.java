package rummikub;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Rij {
    List<Steentje> row = new LinkedList<>();
    protected boolean isValid;

    public Rij(List<Steentje> stenen) {
        row.addAll(stenen);
        checkRij();
    }

    public void checkRij() {
        checkSet();
        checkStraat();
    }

    private void checkSet() {
        List<SteenColor> kleurenList = new LinkedList<>();

        for (Steentje steentje : row) {
            if (steentje.isJoker())
                continue;

            if (!kleurenList.contains(steentje.getColor())) {
                kleurenList.add(steentje.getColor());
            } else isValid = false;
        }

        int jokerIndex = -1;

        for (int i = 0; i < row.size(); i++) {
            if (row.get(i).isJoker())
                jokerIndex = i;
        }

        if (jokerIndex == row.size() - 1) {
            row.get(jokerIndex).setWaarde(row.get(--jokerIndex).getWaarde());
        } else if (jokerIndex >= 0) {
            row.get(jokerIndex).setWaarde(row.get(++jokerIndex).getWaarde());
        }


        for (int i = 1; i < row.size(); i++) {
            if (row.get(i).getWaarde() != row.get(i - 1).getWaarde())
                isValid = false;
        }


        isValid = true;
    }

    private void checkStraat() {
        Set<SteenColor> huidigeKleur = new HashSet<>();

        for (Steentje steentje : row) {
            if (steentje.isJoker())
                continue;
            huidigeKleur.add(steentje.getColor());
        }

        if (huidigeKleur.size() != 1)
            isValid = false;


        int jokerIndex = -1;

        for (int i = 0; i < row.size(); i++) {
            if (row.get(i).isJoker())
                jokerIndex = i;
        }

        if (jokerIndex == row.size() - 1) {
            row.get(jokerIndex).setWaarde(row.get(--jokerIndex).getWaarde() + 1);
        } else if (jokerIndex >= 0) {
            row.get(jokerIndex).setWaarde(row.get(++jokerIndex).getWaarde() - 1);
        }

        for (int i = 1; i < row.size(); i++) {
            if (row.get(i).getWaarde() - row.get(i - 1).getWaarde() != 1)
                isValid = false;
        }
        isValid = true;
    }


    public void check30() {
        int totaal = 0;
        for (Steentje steentje : row) {
            totaal += steentje.getWaarde();
        }
        if (totaal < 30)
            isValid = false;

        isValid = true;
    }

}
