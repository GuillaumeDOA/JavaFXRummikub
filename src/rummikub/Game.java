package rummikub;

public class Game {
    Pot pot;
    Speler[] spelers;

    public Game(int aantalSpelers) {
        this.pot = new Pot();
        this.spelers = new Speler[aantalSpelers];

        for (int i = 0; i < spelers.length; i++) {
            spelers[i] = new Speler();
        }
        for (Speler speler : spelers) {
            for (int i = 0; i < 14; i++) {
                pot.neemSteentje(speler);
            }
        }
    }
}
