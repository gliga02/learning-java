package com.gliga;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static LinkedList<Album> albumi = new LinkedList<>();
    public static void main(String[] args) {
        Album album = new Album("Sta bi dao da si na mom mjestu", "Bijelo dugme");
        album.dodajPesmu("Hop cup", 2.18);
        album.dodajPesmu("Dosao sam da ti kazem da odlazim", 3.36);
        album.dodajPesmu("Ne gledaj me tako i ne ljubi me vise", 6.46);
        album.dodajPesmu("Sta bi dao da si na mom mjestu", 7.42);
        albumi.add(album);

        LinkedList<Pesma> plejlista = new LinkedList<>();
        albumi.get(0).dodajNaPlejlistu("Hop cup", plejlista);
        albumi.get(0).dodajNaPlejlistu("Dosao sam da ti kazem da odlazim", plejlista);

        pusti(plejlista);
    }

    private static void pusti(LinkedList<Pesma> plejlista) {
        boolean quit = false;
        boolean napred = true;
        ListIterator<Pesma> listIterator = plejlista.listIterator();
        if (plejlista.size() == 0) {
            System.out.println("Plejlista je prazna.");
        }

        else {
            System.out.println("Trenutno se pusta " + listIterator.next().toString());
            meni();
        }

        while (!quit) {
            System.out.println("Unesite redni broj zeljene operacije.");
            int opcija = scanner.nextInt();
            scanner.nextLine();

            switch (opcija) {
                case 0:
                    System.out.println("Stop");
                    quit = true;
                    break;

                case 1:
                    if (!napred) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }

                        napred = true;
                    }

                    if (listIterator.hasNext()) {
                        System.out.println("Trenutno se pusta " + listIterator.next().toString());
                    }

                    else {
                        System.out.println("Kraj plejliste");
                        napred = false;
                    }

                    break;

                case 2:
                    if (napred) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }

                        napred = false;
                    }

                    if (listIterator.hasPrevious()) {
                        System.out.println("Trenutno se pusta " + listIterator.previous().toString());
                    }

                    else {
                        System.out.println("Pocetak plejliste");
                        napred = true;
                    }

                    break;

                case 3:
                    if (napred) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Ponovno pustanje " + listIterator.previous().toString());
                            napred = false;
                        }

                        else {
                            System.out.println("Pocetak plejliste");
                        }
                    }

                    else {
                        if (listIterator.hasNext()) {
                            System.out.println("Ponovno pustanje " + listIterator.next().toString());
                            napred = true;
                        }

                        else {
                            System.out.println("Kraj plejliste");
                        }
                    }

                    break;

                case 4:
                    stampajListu(plejlista);
                    break;

                case 5:
                    meni();
                    break;

                case 6:
                    if (plejlista.size() > 0) {
                        listIterator.remove();
                        System.out.println("Pesma je obrisana.");
                        if (listIterator.hasNext()) {
                            System.out.println("Trenutno se pusta " + listIterator.next().toString());
                        }

                        else if (listIterator.hasPrevious()) {
                            System.out.println("Trenutno se pusta " + listIterator.previous().toString());
                        }
                    }

                    break;

            }
        }
    }

    private static void stampajListu(LinkedList<Pesma> plejlista) {
        Iterator<Pesma> iterator = plejlista.iterator();
        System.out.println("==========================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("==========================");
    }

    private static void meni() {
        System.out.println("0. - izlaz\n" +
                "1. - pusti narednu pesmu\n" +
                "2. - pusti prethodnu pesmu\n" +
                "3. - ponovo pusti pesmu\n" +
                "4. - ispisi listu pesama\n" +
                "5. - ispisi meni\n" +
                "6. - obrisi pesmu iz plejliste\n");
    }
}
