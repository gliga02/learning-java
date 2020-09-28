package com.gliga;

import java.util.ArrayList;
import java.util.Collections;

public class Liga<T extends Tim> {
    private String naziv;
    private ArrayList<T> liga = new ArrayList<>();

    public Liga(String naziv) {
        this.naziv = naziv;
    }

    public boolean dodajTim(T tim) {
        if (this.liga.contains(tim)) {
            System.out.println("Ovaj tim vec igra u ligi.");
            return false;
        }

        else {
            this.liga.add(tim);
            System.out.println("Tim " + tim.getNaziv() + " je dodat.");
            return true;
        }
    }

    public void prikaziTabelu() {
        Collections.sort(this.liga);
        for (T tim : this.liga) {
            System.out.println(tim.getNaziv() + ": " + tim.bodovanje());
        }
    }
}
