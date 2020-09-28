package com.gliga;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static LinkedList<Grad> lista = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
	    lista.add(new Grad("Beograd"));
	    lista.add(new Grad("Subotica"));
	    lista.add(new Grad("Arandjelovac"));
	    lista.add(new Grad("Nis"));
	    lista.add(new Grad("Novi Sad"));

	    listaj(lista);
    }

    private static void listaj(LinkedList<Grad> lista) {
        boolean quit = false;
        boolean napred = true;
        ListIterator<Grad> iterator = lista.listIterator();
        if (iterator.hasNext())
            System.out.println("Trenutno sam u " + iterator.next().toString());

        while (!quit) {
            System.out.println("Unesite opciju: '1' ili '2'");
            int opcija = scanner.nextInt();


            switch (opcija) {
                case 0:
                    quit = true;
                    break;


                case 1:
                    if (!napred) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        napred = true;
                    }

                    if (iterator.hasNext()) {
                        System.out.println("Trenutno sam u " + iterator.next().toString());
                    } else {
                        System.out.println("Kraj putovanja");
                        napred = false;
                    }

                    break;

                case 2:
                    if (napred) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }

                        napred = false;
                    }

                    if (iterator.hasPrevious()) {
                        System.out.println("Trenutno sam u " + iterator.previous().toString());
                    } else {
                        System.out.println("Trenutno sam kuci");
                        napred = true;
                    }

                    break;
            }

        }
    }
}
