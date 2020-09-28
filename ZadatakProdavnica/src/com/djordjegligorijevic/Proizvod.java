package com.djordjegligorijevic;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Proizvod {
    private SimpleStringProperty sifra;
    private SimpleStringProperty naziv;
    private SimpleIntegerProperty kolicina;
    private SimpleDoubleProperty cena;

    public Proizvod(String sifra, String naziv, int kolicina, double cena) {
        this.sifra = new SimpleStringProperty(sifra);
        this.naziv = new SimpleStringProperty(naziv);
        this.kolicina = new SimpleIntegerProperty(kolicina);
        this.cena = new SimpleDoubleProperty(cena);
    }

    public String getSifra() {
        return sifra.get();
    }

    public SimpleStringProperty sifraProperty() {
        return sifra;
    }

    public String getNaziv() {
        return naziv.get();
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    public int getKolicina() {
        return kolicina.get();
    }

    public SimpleIntegerProperty kolicinaProperty() {
        return kolicina;
    }

    public double getCena() {
        return cena.get();
    }

    public SimpleDoubleProperty cenaProperty() {
        return cena;
    }

    @Override
    public String toString() {
        return String.format("%s \t%s \t%s \t%s", getSifra(), getNaziv(), getKolicina(), getKolicina() * getCena());
    }
}
