package rummikub;


public class Main {

    public static void main(String[] args) {

        Game RummikubGame = new Game(2);
        RummikubGame.spelers[0].PrintHand();
        RummikubGame.spelers[0].SorteerGetal();
        RummikubGame.spelers[0].PrintHand();

    }
}
