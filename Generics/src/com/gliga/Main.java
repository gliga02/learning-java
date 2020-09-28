package com.gliga;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Liga<Tim<Fudbaler>> ligaSampiona = new Liga<>("Liga sampiona");
        Tim<Fudbaler> realMadrid = new Tim<>("Real Madrid");
        Tim<Fudbaler> roma = new Tim<>("Roma");
        Tim<Fudbaler> plzenj = new Tim<>("Plzenj");
        Tim<Fudbaler> cska = new Tim<>("CSKA");
        Tim<Kosarkas> makabi = new Tim<>("Makabi Tel Aviv");


        ligaSampiona.dodajTim(realMadrid);
        ligaSampiona.dodajTim(roma);
        ligaSampiona.dodajTim(plzenj);
        ligaSampiona.dodajTim(cska);

        realMadrid.rezultati(roma, 1, 1);
        roma.rezultati(plzenj, 2, 0);
        cska.rezultati(realMadrid, 0, 5);

        ligaSampiona.prikaziTabelu();
    }
}
