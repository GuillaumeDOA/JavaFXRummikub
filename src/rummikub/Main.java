package rummikub;


import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hoeveel spelers?");
        Game RummikubGame = new Game(new Scanner(System.in).nextInt());
        for (int i = 0; i < RummikubGame.spelers.length; i++) {
            System.out.println("Speler " + (i+1) + " hand");
            RummikubGame.spelers[i].SorteerKleur();
            RummikubGame.spelers[i].PrintHand();
        }
        RummikubGame.tafel.addSteen(RummikubGame.spelers[0].legSteen(10, 14));
        System.out.println("Tafel: ");
        RummikubGame.tafel.printTafel();
        System.out.println("Speler 1: ");
        RummikubGame.spelers[0].PrintHand();
        RummikubGame.tafel.addSteen(RummikubGame.spelers[0].legSteen(1),1);
        System.out.println("Tafel");
        RummikubGame.tafel.printTafel();
        System.out.println("speler 1");
        RummikubGame.spelers[0].PrintHand();
        RummikubGame.tafel.addSteen(RummikubGame.spelers[0].legSteen(1, 4));
        RummikubGame.tafel.printTafel();

    }
}
