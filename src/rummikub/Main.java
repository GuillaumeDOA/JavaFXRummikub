package rummikub;


import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Hoeveel spelers? ");
        Game RummikubGame = new Game(new Scanner(System.in).nextInt());
        RummikubGame.Start();

    }
}
