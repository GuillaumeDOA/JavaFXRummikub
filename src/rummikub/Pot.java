package rummikub;

import java.util.LinkedList;
import java.util.List;

public class Pot {

    //public Hand potHand = new Hand();
    private List<Steentje> hand = new LinkedList<>();
    public int count;

    public Pot(){
        for (int i = 1; i < 14; i++) {
            hand.add(new Steentje(i,ConsoleColor.RED ));
            hand.add(new Steentje(i,ConsoleColor.RED ));
        }
        for (int i = 1; i < 14; i++) {
            hand.add(new Steentje(i,ConsoleColor.BLACK ));
            hand.add(new Steentje(i,ConsoleColor.BLACK ));
        }
        for (int i = 1; i < 14; i++) {
            hand.add(new Steentje(i,ConsoleColor.BLUE ));
            hand.add(new Steentje(i,ConsoleColor.BLUE ));
        }
        for (int i = 1; i < 14; i++) {
            hand.add(new Steentje(i,ConsoleColor.YELLOW ));
            hand.add(new Steentje(i,ConsoleColor.YELLOW ));
        }
        hand.add(new Steentje(0,ConsoleColor.RED));
        hand.add(new Steentje(0,ConsoleColor.BLACK));
        count = hand.size();
    }


    public void PrintHand(){
        for (Steentje steentje : hand) {
            System.out.print(steentje+ " ");
        }
        System.out.println("");
    }

    public void removeSteen(int i){
        hand.remove(i);
    }


}
