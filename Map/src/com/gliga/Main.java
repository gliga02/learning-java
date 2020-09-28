package com.gliga;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Lokacija> lokacije = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	    Map<String, Integer> tempExit = new HashMap<>();
	    lokacije.put(0, new Lokacija(0, "Kuca", tempExit));

	    tempExit = new HashMap<>();
	    tempExit.put("W", 2);
	    tempExit.put("E", 3);
	    tempExit.put("S", 4);
	    tempExit.put("N", 5);
	    lokacije.put(1, new Lokacija(1, "Park", tempExit));

	    tempExit = new HashMap<>();
	    tempExit.put("N", 5);
	    lokacije.put(2, new Lokacija(2, "Planina", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        lokacije.put(3, new Lokacija(3, "Zgrada",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        lokacije.put(4, new Lokacija(4, "Autobuska stanica",tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        lokacije.put(5, new Lokacija(5, "Selo",tempExit));


        Map<String, String> vokabular = new HashMap<>();
        vokabular.put("QUIT", "Q");
        vokabular.put("NORTH", "N");
        vokabular.put("SOUTH", "S");
        vokabular.put("WEST", "W");
        vokabular.put("EAST", "E");

        int lok = 1;
        while (true) {
            System.out.println(lokacije.get(lok).getNazivLokacije());
            if (lok == 0) {
                break;
            }

            Map<String, Integer> izlazi = lokacije.get(lok).getExits();
            System.out.println("Dostupni izlazi ");
            for (String izlaz : izlazi.keySet()) {
                System.out.println(izlaz + ", ");
            }

            String pravac = scanner.nextLine().toUpperCase();
            if (pravac.length() > 1) {
                String[] reci = pravac.split(" ");
                for (String rec : reci) {
                    if (vokabular.containsKey(rec)) {
                        pravac = vokabular.get(rec);
                        break;
                    }
                }
            }

            if (izlazi.containsKey(pravac)) {
                lok = izlazi.get(pravac);
            } else {
                System.out.println("Ne mozes ici u ovom pravcu");
            }
        }

     }
}
