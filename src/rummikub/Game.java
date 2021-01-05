package rummikub;

import java.util.*;

public class Game {
    Pot pot;
    Speler[] spelers;
    Tafel tafel;
    private int huideSpeler;
    private Scanner kb = new Scanner(System.in);

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
        huideSpeler = new Random().nextInt(spelers.length);
    }

    public void Start() {
        System.out.printf("Speler %d mag beginnen %n", (huideSpeler + 1));
        while (checkGameEnd()) {
            System.out.println("Tafel: \n");
            tafel.printTafel();
            System.out.println("\nDe beurt is aan Speler " + (huideSpeler + 1));
            spelers[huideSpeler].printHand();
            System.out.println("Wat wil je doen? \n\t1) Steentje nemen\n\t2) Steentjes leggen\n\t3) Sorteer Steentjes op kleur\n\t4) Sorteer Steentjes op getal");
            int speelKeuze = kb.nextInt();
            switch (speelKeuze) {
                case 1:
                    pot.neemSteentje(spelers[huideSpeler]);
                    spelers[huideSpeler].printHand();
                    volgendeSpeler();
                    break;
                case 2:
                    legStenen(spelers[huideSpeler]);
                    if (!spelers[huideSpeler].getAfgelegd()) {
                        if (tafel.check30Set()) {
                            if (tafel.checkTafel()) {
                                spelers[huideSpeler].setAfgelegd(true);
                                volgendeSpeler();
                            } else {
                                System.out.println("Geen geldige rij");
                                tafel.returnSteentjes(spelers[huideSpeler]);
                            }
                        } else {
                            System.out.println("Rij moet minstens 30 zijn om af te leggen");
                            tafel.returnSteentjes(spelers[huideSpeler]);
                        }
                    } else {
                        if (tafel.checkTafel()) {
                            volgendeSpeler();
                        } else {
                            System.out.println("Geen geldige rij");
                            tafel.returnSteentjes(spelers[huideSpeler]);
                        }
                    }

                    break;
                case 3:
                    spelers[huideSpeler].SorteerKleur();
                    break;
                case 4:
                    spelers[huideSpeler].SorteerGetal();
                    break;
                default:
                    System.out.println("Onbekende keuze!");
            }
        }
    }

    public void volgendeSpeler() {
        if (huideSpeler == spelers.length - 1) huideSpeler = 0;
        else huideSpeler++;
    }

    public boolean checkGameEnd() {
        for (int i = 0; i < spelers.length; i++) {
            if (spelers[i].getSize() > 0) return true;
        }
        return false;
    }

    public void legStenen(Speler sp) {
        System.out.println("\t1) Nieuwe rij leggen\n\t2) Comming Soon!");
        int spelerKeuze = kb.nextInt();
        kb.nextLine();
        switch (spelerKeuze) {
            case 1:
                System.out.print("Welke stenen wil je allemaal leggen? ");
                String input = kb.nextLine();
                String[] antwoorden = input.split(" ");
                List<Steentje> stenen = new LinkedList<>();
                for (int i = 0; i <antwoorden.length ; i++) {
                    stenen.add(sp.legSteen(Integer.parseInt(antwoorden[i])));
                }
                tafel.addSteen(stenen);
                spelers[huideSpeler].getBord().getHand().removeAll(stenen);

//                tafel.addSteen(sp.legSteen(kb.nextInt(), kb.nextInt()));
                break;
//            case 2:
//                System.out.println("Welke steen leg je bij en bij welke rij leg je deze steen bij ");
//                tafel.addSteen(sp.legSteen(kb.nextInt()),kb.nextInt());
//                break;
            default:
                System.out.println("Onbekende keuze!");
        }
    }
}
