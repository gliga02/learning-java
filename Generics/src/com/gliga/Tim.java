package com.gliga;

import java.util.ArrayList;

public class Tim<T extends Igrac> implements Comparable<Tim<T>>{
    private String naziv;

    private ArrayList<T> igraci = new ArrayList<>();

    int odigraneUtakmice = 0;
    int dobijeneUtakmice = 0;
    int izgubljeneUtakmice = 0;
    int nereseneUtakmice = 0;

    public Tim(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public boolean dodajIgraca(T igrac) {
        if (this.igraci.contains(igrac)) {
            System.out.println("Igrac " + igrac.getIme() + " je vec u timu.");
            return false;
        }

        else {
            igraci.add(igrac);
            System.out.println("Igrac " + igrac.getIme() + " je ubacen u tim.");
            return true;
        }
    }

    public int brojIgraca() {
        return this.igraci.size();
    }

    public void rezultati(Tim<T> protivnik, int nasSkor, int protivnickiSkor) {
        String poruka;
        if (nasSkor > protivnickiSkor) {
            dobijeneUtakmice++;
            poruka = " je pobedio ";
        }

        else if (nasSkor == protivnickiSkor) {
            nereseneUtakmice++;
            poruka = " je odigrao nereseno sa ";
        }

        else {
            izgubljeneUtakmice++;
            poruka = " je izgibo od ";
        }

        odigraneUtakmice++;
        if (protivnik != null) {
            System.out.println("Tim " + this.getNaziv() + poruka + protivnik.getNaziv());
            protivnik.rezultati(null, protivnickiSkor, nasSkor);
        }
    }

    public int bodovanje() {
        return (dobijeneUtakmice * 2) + nereseneUtakmice;
    }

    @Override
    public int compareTo(Tim<T> o) {
        if (this.bodovanje() > o.bodovanje()) {
            return -1;
        }

        else if (this.bodovanje() < o.bodovanje()) {
            return 1;
        }

        else return 0;
    }
}
