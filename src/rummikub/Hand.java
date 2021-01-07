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

    public void printHand() {
        for (int i = 0; i < hand.size(); i++) {
            System.out.printf("%2d ", i + 1);
        }
        System.out.println("");
        for (Steentje steentje : hand) {
            System.out.printf("%11s ", steentje);
        }

        System.out.println("");
    }

    public int getSize() {
        return hand.size();
    }
}
