package com.meinprojekt;

public class App {
    public static void main(String[] args) {

        Risiko a = new AkzeptablesRisiko("abc", 20, 1447);
        Risiko b = new ExtremesRisiko("def", 40, 6767, "jajaja", 99999);
        Risiko c = new InakzeptablesRisiko("ghi", 60, 2424, "neinnein");

        a.druckeDaten();
        b.druckeDaten();
        c.druckeDaten();
    }
}
