package com.gliga;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String naziv;
    private String izvodjac;
    private ArrayList<Pesma> pesme;

    public Album(String naziv, String izvodjac) {
        this.naziv = naziv;
        this.izvodjac = izvodjac;
        this.pesme = new ArrayList<>();
    }

    public boolean dodajPesmu(String naslov, double trajanje) {
        if (pronadjiPesmu(naziv) == null) {
            this.pesme.add(new Pesma(naslov, trajanje));
            System.out.println("Pesma je dodata.");
            return true;
        }

        else {
            System.out.println("Pesma je vec dodata na plejlistu.");
            return false;
        }
    }

    public Pesma pronadjiPesmu(String naziv) {
        for (Pesma pesma : this.pesme) {
            if (pesma.getNaslov().equals(naziv)) {
                return pesma;
            }
        }

        return null;
    }

    public boolean dodajNaPlejlistu(String naziv, LinkedList<Pesma> pesme) {
        Pesma pesma = pronadjiPesmu(naziv);
        if (pesma != null) {
            pesme.add(pesma);
            System.out.println("Pesma " + pesma.getNaslov() + " je dodata na plejlistu.");
            return true;
        }

        else {
            System.out.println("Pesma ne postoji u ovom albumu.");
            return false;
        }
    }
}
