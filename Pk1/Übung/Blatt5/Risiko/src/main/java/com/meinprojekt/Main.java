package com.meinprojekt;

public class Main {
    public static void main(String[] args) {

        Risiko a = new AkzeptablesRisiko("abc", 20, 1447);
        Risiko b = new ExtremesRisiko("def", 40, 6767, "jajaja", 99999);
        Risiko c = new InakzeptablesRisiko("ghi", 60, 2424, "neinnein");

        Risiko d = new AkzeptablesRisiko("abc", 20, 1447);
        Risiko e = new ExtremesRisiko("def", 40, 6767, "jajaja", 99999);
        Risiko f = new InakzeptablesRisiko("ghi", 60, 2424, "neinnein");

        a.druckeDaten(System.out);
        b.druckeDaten(System.out);
        c.druckeDaten(System.out);

        System.out.println();
        System.out.println("is " + a.getBezeichnung() + "equal " + d.getBezeichnung() + "? " + a.equals(d));
        System.out.println("is " + a.getBezeichnung() + "equal " + a.getBezeichnung() + "? " + a.equals(a));
        System.out.println("is " + a.getBezeichnung() + "equal " + e.getBezeichnung() + "? " + a.equals(e));
        System.out.println("is " + b.getBezeichnung() + "equal " + f.getBezeichnung() + "? " + b.equals(f));

        Risikoverwaltung verwaltung = new Risikoverwaltung();
        verwaltung.aufnehmen(a);
        verwaltung.aufnehmen(b);
        verwaltung.aufnehmen(c);
        verwaltung.aufnehmen(d);
        verwaltung.aufnehmen(e);

        System.out.println();
        verwaltung.zeigeRisiken(System.out);

        System.out.println();
        verwaltung.sucheRisikoMitMaxRueckstellung(System.out);

        System.out.println();
        System.out.println(verwaltung.brechneSummeRueckstellungen() + "\n");

        Menu m = new Menu(verwaltung);
        m.printMenu();
    }
}
