package rummikub;

import com.sun.source.tree.LiteralTree;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Tafel {
    private List<List<Steentje>> gelegedeRijen;
    private List<Steentje> tempRijen;

    public Tafel() {
        gelegedeRijen = new LinkedList<>();
        tempRijen = new LinkedList<>();
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

    public boolean checkTafel() {
        if (!checkLengte()) return false;
        if (checkGetallenSet() || checkOpeenvolging())
            return true;
        else return false;
    }

    public boolean checkOpeenvolging() {
        for (List<Steentje> steentjes : gelegedeRijen) {
            for (int i = 1; i < steentjes.size(); i++) {
                if (steentjes.get(i).getWaarde() - steentjes.get(i - 1).getWaarde() != 1 || steentjes.get(i).getColor() != steentjes.get(i - 1).getColor())
                    return false;
            }
        }
        return true;
    }
    
    public boolean checkGetallenSet() {

        for (List<Steentje> steentjes : gelegedeRijen) {
            List<SteenColor> kleurenList = new LinkedList<>();
            boolean bevatJoker = false;
            for (Steentje steentje : steentjes) {
                if (steentje.isJoker()) {
                    bevatJoker = true;
                    continue;
                }

                if (!kleurenList.contains(steentje.getColor())) {
                    kleurenList.add(steentje.getColor());
                } else return false;
            }

            double totaal = 0;
            for (Steentje steentje : steentjes) {
                totaal += steentje.getWaarde();
            }

            if (bevatJoker) {
                int index = 0;
                if (steentjes.get(0).getWaarde() == 0)
                    index = 1;
                if (totaal != steentjes.get(index).getWaarde() * (steentjes.size() - 1)) {
                    return false;
                }
            } else {
                if (totaal != steentjes.get(0).getWaarde() * steentjes.size()) {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean checkLengte() {
        for (List<Steentje> steentjes : gelegedeRijen) {
            if (steentjes.size() < 3) return false;
        }
        return true;
    }

    public boolean check30Set() {

        for (List<Steentje> steentjes : gelegedeRijen) {
            double totaal = 0;

            for (Steentje steentje : steentjes) {
                if(steentje.isJoker()){
                    int sum=0;
                    for (Steentje steentje1 : steentjes) {
                        sum+=steentje1.getWaarde();
                    }
                    sum/=steentjes.size()-1;
                    totaal+=sum;
                }

                totaal += steentje.getWaarde();
            }

            if (totaal < 30) {
                return false;
            }
        }

        return true;
    }

    public boolean check30Opeenvolging() {


        return false;
    }


    public void returnSteentjes(Speler sp) {
        List<Steentje> list = gelegedeRijen.remove(gelegedeRijen.size() - 1);
        for (Steentje steentje : list) {
            sp.addSteentje(steentje);
        }
    }
}
