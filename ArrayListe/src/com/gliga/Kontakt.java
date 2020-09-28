package com.gliga;

public class Kontakt {
    private String ime;
    private String brojTelefona;

    public Kontakt(String ime, String brojTelefona) {
        this.ime = ime;
        this.brojTelefona = brojTelefona;
    }

    public String getIme() {
        return ime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public static Kontakt napraviKontakt(String ime, String brojTelefona) {
        return new Kontakt(ime, brojTelefona);
    }
}
