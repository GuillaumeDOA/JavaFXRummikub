package rummikub;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Tafel {
    private List<List<Steentje>> gelegedeRijen;
    private List<Steentje> tempRij;

    public Tafel() {
        gelegedeRijen = new LinkedList<>();
        tempRij = new LinkedList<>();
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

//    public boolean CheckOpeenVolging(){
//        int counter=0;
//        for (List<Steentje> steentjes : gelegedeRijen) {
//            for (Iterator<Steentje> iterator = steentjes.iterator(); iterator.hasNext(); ) {
//                Steentje next =  iterator.next();
//
//
//            }
//        }
//        return false;
//    }


    public boolean checkGetallenSet() {
//        for (List<Steentje> steentjes : gelegedeRijen) {
//            for (int i = 1; i < steentjes.size(); i++) {
//                if (steentjes.get(i).getWaarde() - steentjes.get(i - 1).getWaarde() != 0)
//                    return false;
//            }
//        }
        List<SteenColor> kleurenList = new LinkedList<>();
        for (List<Steentje> steentjes : gelegedeRijen) {
            for (int i=1;i<steentjes.size();i++) {
                if (!kleurenList.contains(steentjes.get(i-1).getColor())) {
                    kleurenList.add(steentjes.get(i-1).getColor());
                } else return true;

                if(steentjes.get(i-1).getWaarde()!=steentjes.get(i).getWaarde()){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkLengte() {
        for (List<Steentje> steentjes : gelegedeRijen) {
            if (steentjes.size() < 3) return false;
        }
        return true;
    }

    public boolean check30() {
        int som = 0;
        List<Steentje> list = gelegedeRijen.get(gelegedeRijen.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            som += list.get(i).getWaarde();
        }
        if (som >= 30) return true;
        else return false;
    }


    public void returnSteentjes(Speler sp) {
        List<Steentje> list = gelegedeRijen.remove(gelegedeRijen.size() - 1);
        for (Steentje steentje : list) {
            sp.addSteentje(steentje);
        }
    }
}
