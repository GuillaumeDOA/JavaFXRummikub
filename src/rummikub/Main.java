package rummikub;

import java.io.Console;

public class Main {

    public static void main(String[] args) {

        Pot pot = new Pot();
        pot.PrintHand();
        System.out.println(pot.count);

    }
}
