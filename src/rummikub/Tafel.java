package rummikub;

import java.util.*;

public class Tafel {
    private List<List<Steentje>> gelegedeRijen;
    private List<Rij> rijen;
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

    public void addSteen(Steentje steen, int rij,char plaats) {
        switch (plaats) {
            case 'a':
                gelegedeRijen.get(--rij).add(steen);
                break;
            case 'v':
                gelegedeRijen.get(--rij).add(0,steen);
        }
    }

    public void addSteen(List<Steentje> stenen) {
        rijen.add(new Rij(stenen));
        gelegedeRijen.add(stenen);
    }

    public boolean checkTafel() {
        if(gelegedeRijen.size()==0) return false;
        if (!checkLengte()) return false;
        if (checkGetallenSet() || checkOpeenvolging())
            return true;
        else return false;
    }

    public boolean checkOpeenvolging() {
//        for (List<Steentje> rij : gelegedeRijen) {
////            for (int i = 1; i < steentjes.size(); i++) {
////                if (steentjes.get(i).getWaarde() - steentjes.get(i - 1).getWaarde() != 1 || steentjes.get(i).getColor() != steentjes.get(i - 1).getColor())
////                    return false;
////            }
////        }
//            Set<SteenColor> huidigeKleur = new HashSet<>();
//
//            for (Steentje steentje : rij) {
//                if (steentje.isJoker())
//                    continue;
//                huidigeKleur.add(steentje.getColor());
//            }
//
//            if (huidigeKleur.size() != 1)
//                return false;
//
//
//            int jokerIndex = -1;
//
//            for (int i = 0; i < rij.size(); i++) {
//                if (rij.get(i).isJoker())
//                    jokerIndex = i;
//            }
//
//            if (jokerIndex == rij.size() - 1) {
//                rij.get(jokerIndex).setWaarde(rij.get(--jokerIndex).getWaarde() + 1);
//            } else if (jokerIndex >= 0) {
//                rij.get(jokerIndex).setWaarde(rij.get(++jokerIndex).getWaarde() - 1);
//            }
//
//            for (int i = 1; i < rij.size(); i++) {
//                if (rij.get(i).getWaarde() - rij.get(i - 1).getWaarde() != 1)
//                    return false;
//            }
//        }

        return true;
    }

    public boolean checkGetallenSet() {
//
//        for (List<Steentje> rij : gelegedeRijen) {
//
//            List<SteenColor> kleurenList = new LinkedList<>();
//
//            for (Steentje steentje : rij) {
//                if (steentje.isJoker())
//                    continue;
//
//                if (!kleurenList.contains(steentje.getColor())) {
//                    kleurenList.add(steentje.getColor());
//                } else return false;
//            }
//
//            int jokerIndex = -1;
//
//            for (int i = 0; i < rij.size(); i++) {
//                if (rij.get(i).isJoker())
//                    jokerIndex = i;
//            }
//
//            if (jokerIndex == rij.size() - 1) {
//                rij.get(jokerIndex).setWaarde(rij.get(--jokerIndex).getWaarde());
//            } else if (jokerIndex >= 0) {
//                rij.get(jokerIndex).setWaarde(rij.get(++jokerIndex).getWaarde());
//            }
//
//
//            for (int i = 1; i < rij.size(); i++) {
//                if (rij.get(i).getWaarde() != rij.get(i - 1).getWaarde())
//                    return false;
//            }
//
////            for (Steentje steentje : rij) {
////                totaal += steentje.getWaarde();
////            }
////
////            if (bevatJoker) {
////                int index = 0;
////                if (rij.get(0).getWaarde() == 0)
////                    index = 1;
////                if (totaal != rij.get(index).getWaarde() * (rij.size() - 1)) {
////                    return false;
////                }
////            } else {
////                if (totaal != rij.get(0).getWaarde() * rij.size()) {
////                    return false;
////                }
////            }
//
//        }
        return true;
    }

    public boolean checkLengte() {
        for (List<Steentje> rij : gelegedeRijen) {
            if (rij.size() < 3) return false;
        }
        return true;
    }

    public boolean check30() {
        for (List<Steentje> rij : gelegedeRijen) {
            int totaal = 0;
            for (Steentje steentje : rij) {
                totaal += steentje.getWaarde();
            }
            if (totaal < 30)
                return false;
        }
        return true;
    }

    public void returnSteentjes(Speler sp) {
        if(gelegedeRijen.size()==0) return;
        List<Steentje> list = gelegedeRijen.remove(gelegedeRijen.size() - 1);
        for (Steentje steentje : list) {
            sp.addSteentje(steentje);
        }
    }
}
