package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Ucenik {
    private SimpleStringProperty ime;
    private SimpleStringProperty prezime;
    private SimpleDoubleProperty prosek;

    public Ucenik(String ime, String prezime, double prosek) {
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.prosek = new SimpleDoubleProperty(prosek);
    }

    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = new SimpleStringProperty(ime);
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = new SimpleStringProperty(prezime);
    }

    public double getProsek() {
        return prosek.get();
    }

    public SimpleDoubleProperty prosekProperty() {
        return prosek;
    }

    public void setProsek(double prosek) {
        this.prosek = new SimpleDoubleProperty(prosek);
    }

    @Override
    public String toString() {
        return this.getIme() + " " + this.getPrezime();
    }


}
