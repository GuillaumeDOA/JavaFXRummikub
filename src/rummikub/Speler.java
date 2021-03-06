package rummikub;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Speler {

    private Hand bord;
    private String naam;
    private boolean afgelegd;

    public Speler() {
        bord = new Hand();
        afgelegd=false;
    }

    public void printHand() {
        bord.printHand();
    }

    public Hand getBord() {
        return bord;
    }

    public boolean getAfgelegd() {
        return afgelegd;
    }

    public void setAfgelegd(boolean afgelegd) {
        this.afgelegd = afgelegd;
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

    public Steentje legSteen(int index) {
        return bord.getHand().get(--index);
    }

    public List<Steentje> legSteen(int start, int einde){
        List<Steentje> list = new LinkedList<>();
        for (int i = --start; i <einde ; i++) {
            list.add(bord.getHand().remove(start));
        }
        return list;
    }

    public List<Steentje> legSteen(List<Steentje> rij){
        return rij;
    }

    public int getSize(){
        return bord.getSize();
    }
}
