package rummikub;

import java.util.*;

public class Hand {

    private List<Steentje> hand;

    public List<Steentje> getHand() {
        return hand;
    }

    public Hand() {
        hand = new LinkedList<>();
    }

    public void PrintHand() {
        for (Steentje steentje : hand) {
            System.out.print(steentje + " ");
        }
        System.out.println("");
    }

    public int getSize() {
        return hand.size();
    }
}
