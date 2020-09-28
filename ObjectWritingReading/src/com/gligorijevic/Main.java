package com.gligorijevic;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Person[] people = new Person[3];
	    try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(new File("list.dat")))) {
            for (int i = 0; i < 3; i++) {
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                System.out.println("Enter year: ");
                int year = scanner.nextInt();
                scanner.nextLine();
                people[i] = new Person(name, year);
                o.writeObject(people[i]);
            }
        } catch (IOException e) {
	        e.printStackTrace();
        }

	    try (ObjectInputStream i = new ObjectInputStream(new FileInputStream(new File("list.dat")))) {
	        boolean eof = false;
	        try {
	            while (!eof) {
	                try {
                        Person person = (Person) i.readObject();
                        if (person.getYear() > 2001) {
                            System.out.println(person.toString());
                        }
                    }

	                catch (EOFException e) {
	                    eof = true;
                    }
                }
            } catch (ClassNotFoundException e) {
	            e.printStackTrace();
            }
        } catch (IOException e) {
	        e.printStackTrace();
        }
    }
}
