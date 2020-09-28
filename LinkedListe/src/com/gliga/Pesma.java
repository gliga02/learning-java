package com.gliga;

public class Pesma {
    private String naslov;
    private double trajanje;

    public Pesma(String naslov, double trajanje) {
        this.naslov = naslov;
        this.trajanje = trajanje;
    }

    public String getNaslov() {
        return naslov;
    }

    @Override
    public String toString() {
        return this.naslov + " : " + this.trajanje;
    }
}
