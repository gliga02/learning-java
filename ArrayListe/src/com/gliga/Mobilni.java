package com.gliga;

import java.util.ArrayList;

public class Mobilni {
    private ArrayList<Kontakt> kontakti;

    public Mobilni() {
        this.kontakti = new ArrayList<>();
    }

    public boolean dodajKontakt(Kontakt kontakt) {
        if (this.kontakti.contains(kontakt)) {
            System.out.println("Kontakt " + kontakt.getIme() + " : " + kontakt.getBrojTelefona() + " vec postoji u imeniku.");
            return false;
        }

        else {
            this.kontakti.add(kontakt);
            System.out.println("Kontakt " + kontakt.getIme() + " : " + kontakt.getBrojTelefona() + " je kreiran.");
            return true;
        }
    }

    public boolean brisiKontakt(Kontakt kontakt) {
        if (this.kontakti.contains(kontakt)) {
            this.kontakti.remove(kontakt);
            System.out.println("Kontakt " + kontakt.getIme() + " : " + kontakt.getBrojTelefona() + " je obrisan.");
            return true;
        }

        else {
            System.out.println("Kontakt ne postoji u imeniku.");
            return false;
        }
    }


    public boolean izmeniKontakt(Kontakt kontakt, Kontakt noviKontakt) {
        int pozicija = pronadjiKontakt(kontakt);
        if (pozicija >= 0) {
            this.kontakti.set(pozicija, noviKontakt);
            System.out.println("Kontakt " + kontakt.getIme() + " je azuriran.");
            return true;
        }

        else {
            System.out.println("Kontakt nije pronadjen.");
            return false;
        }
    }

    private int pronadjiKontakt(Kontakt kontakt) {
        return this.kontakti.indexOf(kontakt);
    }

    private int pronadjiKontakt(String ime) {
        for (int i = 0; i < this.kontakti.size(); i++) {
            if (this.kontakti.get(i).getIme().equals(ime)) {
                return i;
            }
        }

        return -1;
    }

    public String pretraziKontakte(Kontakt kontakt) {
        if (pronadjiKontakt(kontakt) >= 0) {
            return kontakt.getIme();
        }

        return null;
    }

    public Kontakt pretraziKontakte(String ime) {
        int pozicija = pronadjiKontakt(ime);
        if (pozicija >= 0) {
            return this.kontakti.get(pozicija);
        }

        return null;
    }

    public void stampajKontakte() {
        for (int i = 0; i < this.kontakti.size(); i++) {
            System.out.println(this.kontakti.get(i).getIme() + " : " + this.kontakti.get(i).getBrojTelefona());
        }
    }

}
