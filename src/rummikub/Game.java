package rummikub;

public class Game {
    Pot pot;
    Speler[] spelers;
    Tafel tafel;
    private int huideSpeler;

    public Game(int aantalSpelers) {
        this.pot = new Pot();
        this.spelers = new Speler[aantalSpelers];
        this.tafel = new Tafel();

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
