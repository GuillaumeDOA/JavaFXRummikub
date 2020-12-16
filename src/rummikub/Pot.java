package rummikub;


import java.util.Collections;

public class Pot {

    private Hand Zak;


    public Pot() {
        Zak = new Hand();
        for (int i = 1; i < 14; i++) {

            Zak.getHand().add(new Steentje(i, SteenColor.RED));
            Zak.getHand().add(new Steentje(i, SteenColor.RED));
        }
        for (int i = 1; i < 14; i++) {
            Zak.getHand().add(new Steentje(i, SteenColor.BLACK));
            Zak.getHand().add(new Steentje(i, SteenColor.BLACK));
        }
        for (int i = 1; i < 14; i++) {
            Zak.getHand().add(new Steentje(i, SteenColor.BLUE));
            Zak.getHand().add(new Steentje(i, SteenColor.BLUE));
        }
        for (int i = 1; i < 14; i++) {
            Zak.getHand().add(new Steentje(i, SteenColor.YELLOW));
            Zak.getHand().add(new Steentje(i, SteenColor.YELLOW));
        }
        Zak.getHand().add(new Steentje(0, SteenColor.RED));
        Zak.getHand().add(new Steentje(0, SteenColor.BLACK));
        Collections.shuffle(Zak.getHand());
    }

    public void neemSteentje(Speler sp) {
        sp.addSteentje(Zak.getHand().remove(0));
    }

}
