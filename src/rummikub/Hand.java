package rummikub;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Hand {

    private List<Steentje> hand = new LinkedList<>();

    public Hand() {
    }

    public void PrintHand(){
        for (Steentje steentje : hand) {
            System.out.print(steentje + " ");
        }
    }

    public void AddSteentje(Steentje steen){
        hand.add(steen);
    }

    public Steentje NeemSteentje(){
        Steentje steen = hand.get(new Random().nextInt());
        return steen;
    }
}
