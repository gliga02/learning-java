package com.gliga;

import java.util.HashMap;
import java.util.Map;

public class Lokacija {
    private final int lokacijaID;
    private final String nazivLokacije;
    private final Map<String, Integer> exits;

    public Lokacija(int lokacijaID, String nazivLokacije, Map<String, Integer> exits) {
        this.lokacijaID = lokacijaID;
        this.nazivLokacije = nazivLokacije;
        if (exits != null) {
            this.exits = new HashMap<>(exits);
        }

        else {
            this.exits = new HashMap<>();
        }

        this.exits.put("Q", 0);
    }

    public int getLokacijaID() {
        return lokacijaID;
    }

    public String getNazivLokacije() {
        return nazivLokacije;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }
}
