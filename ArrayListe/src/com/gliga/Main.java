package com.gliga;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Mobilni mobilni = new Mobilni();
    public static void main(String[] args) {
        boolean quit = false;
        pokreniTelefon();
        meni();
        while (!quit) {
            System.out.println("Unesite redni broj zeljene operacije: ");
            int opcija = scanner.nextInt();
            scanner.nextLine();
            switch (opcija) {
                case 0:
                    System.out.println("Telefon se iskljucuje...");
                    quit = true;
                    break;

                case 1:
                    dodajKontakt();
                    break;

                case 2:
                    brisiKontakt();
                    break;

                case 3:
                    izmeniKontakt();
                    break;

                case 4:
                    pretraziKontakte();
                    break;

                case 5:
                    mobilni.stampajKontakte();
                    break;

                case 6:
                    meni();
                    break;

                default:
                    System.out.println("Izabrali ste nepostojecu operaciju.");
            }
        }
    }

    private static void dodajKontakt() {
        System.out.println("Unesite ime: ");
        String ime = scanner.nextLine();
        System.out.println("Unesite broj telefona: ");
        String brojTelefona = scanner.nextLine();
        Kontakt noviKontakt = Kontakt.napraviKontakt(ime, brojTelefona);
        if (mobilni.dodajKontakt(noviKontakt)) {
            System.out.println("Kontakt je uspesno dodat.");
        }

        else {
            System.out.println("Greska, kontakt vec postoji.");
        }
    }

    private static void brisiKontakt() {
        System.out.println("Unesite ime kontakta: ");
        String ime = scanner.nextLine();
        Kontakt kontakt = mobilni.pretraziKontakte(ime);
        if (kontakt == null) {
            System.out.println("Kontakt nije pronadjen.");
        }

        else {
            mobilni.brisiKontakt(kontakt);
            System.out.println("Kontakt je uspesno obrisan.");
        }
    }

    private static void izmeniKontakt() {
        System.out.println("Unesite ime kontakta: ");
        String ime = scanner.nextLine();
        Kontakt kontakt = mobilni.pretraziKontakte(ime);
        if (kontakt == null) {
            System.out.println("Kontakt nije pronadjen.");
        }

        System.out.println("Unesite novo ime");
        String novoIme = scanner.nextLine();
        System.out.println("Unesite novi broj telefona");
        String noviBroj = scanner.nextLine();
        Kontakt noviKontakt = Kontakt.napraviKontakt(novoIme, noviBroj);

        if (mobilni.izmeniKontakt(kontakt, noviKontakt)) {
            System.out.println("Kontakt je uspesno izmenjen.");
        }

        else {
            System.out.println("Greska...");
        }
    }

    private static void pretraziKontakte() {
        System.out.println("Unesite ime kontakta: ");
        String ime = scanner.nextLine();
        Kontakt kontakt = mobilni.pretraziKontakte(ime);
        if (kontakt == null) {
            System.out.println("Kontakt nije pronadjen.");
        }

        else {
            System.out.println("Broj kontakta " + kontakt.getIme() + " je " + kontakt.getBrojTelefona() + ".");
        }
    }

    private static void pokreniTelefon() {
        System.out.println("Pokretanje telefona...");
    }

    private static void meni() {
        System.out.println("0. - Iskljuci telefon\n" +
                "1. - Dodaj novi kontakt\n" +
                "2. - Obrisi kontakt\n" +
                "3. - Izmeni kontakt\n" +
                "4. - Pretrazi kontakt\n" +
                "5. - Ispisi sve kontakte\n" +
                "6. - Ispisi sve opcije\n");
    }
}
