package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.Iterator;

public class UcenikModel {
    private static UcenikModel instance = new UcenikModel();
    private static String fajl = "ucenici.txt";

    private ObservableList<Ucenik> ucenici;

    public static UcenikModel getInstance() {
        return instance;
    }

    public ObservableList<Ucenik> getUcenici() {
        return ucenici;
    }

    public void unesiUcenika(Ucenik ucenik) {
        ucenici.add(ucenik);
    }

    public void izbrisiUcenika(Ucenik ucenik) {
        ucenici.remove(ucenik);
    }

    public void sacuvajUcenika() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fajl))) {
            Iterator<Ucenik> iterator = ucenici.iterator();
            while (iterator.hasNext()) {
                Ucenik ucenik = iterator.next();
                bw.write(String.format("%s\t%s\t%f", ucenik.getIme(), ucenik.getPrezime(), ucenik.getProsek()));
                bw.newLine();
            }
        }
    }

    public void citajUcenia() throws IOException {
        ucenici = FXCollections.observableArrayList();
        String input;
        try (BufferedReader br = new BufferedReader(new FileReader(fajl))) {
            while ((input = br.readLine()) != null) {
                String[] data = input.split("\t");

                String ime = data[0];
                String prezime = data[1];
                double prosek = Double.parseDouble(data[2]);

                Ucenik ucenik = new Ucenik(ime, prezime, prosek);
                ucenici.add(ucenik);
            }
        }
    }
}
