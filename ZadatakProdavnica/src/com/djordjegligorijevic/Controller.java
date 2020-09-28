package com.djordjegligorijevic;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField sifraField;

    @FXML
    private TextField nazivField;

    @FXML
    private TextField kolicinaField;

    @FXML
    private TextField cenaField;

    @FXML
    private ListView<String> korpa;

    @FXML
    private Label iznos;

    @FXML
    private Label iznosPorez;

    @FXML
    private ListView<String> povrat;

    private ObservableList<String> proizvodi;

    private static double ukupanIznos;
    private static double ukupanIznosPorez;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        proizvodi = FXCollections.observableArrayList();
        iznos.visibleProperty().setValue(false);
        iznosPorez.visibleProperty().setValue(false);
    }

    public void dodajUKorpu() {
        try {
            String sifra = sifraField.getText();
            String naziv = nazivField.getText();
            int kolicina = Integer.parseInt(kolicinaField.getText());
            double cena = Double.parseDouble(cenaField.getText());
            ukupanIznos += cena * (double)kolicina;
            ukupanIznosPorez += (cena + cena * 0.2) * kolicina;
            Proizvod proizvod = new Proizvod(sifra, naziv, kolicina, cena);
            proizvodi.add(proizvod.toString());
            korpa.setItems(proizvodi);
            iznos.setText("Iznos bez poreza iznosi: " + ukupanIznos);
            iznosPorez.setText("Iznos sa porezom iznosi: " + ukupanIznosPorez);
            sifraField.clear();
            nazivField.clear();
            kolicinaField.clear();
            cenaField.clear();
        } catch (IllegalArgumentException e) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Greska");
           alert.setHeaderText(null);
           alert.setContentText("Niste uneli podatke");
           alert.showAndWait();
        }
    }

    public void izbaciIzKorpe() {
        String selektovanProizvod = korpa.getSelectionModel().getSelectedItem();
        if (selektovanProizvod == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Korpa je prazna");
            alert.setHeaderText(null);
            alert.setContentText("Korpa je prazna");
            alert.showAndWait();
            return;
        }
        proizvodi.remove(selektovanProizvod);
        korpa.getSelectionModel().setSelectionMode(null);
        povrat.getItems().addAll(selektovanProizvod);
        String[] data;
        data = selektovanProizvod.split("\t");
        ukupanIznos -= Double.parseDouble(data[3]);
        ukupanIznosPorez -= Double.parseDouble(data[3]) + Double.parseDouble(data[3]) * 0.2;
        iznos.setText("Iznos bez poreza iznosi: " + ukupanIznos);
        iznosPorez.setText("Iznos sa porezom iznosi: " + ukupanIznosPorez);
    }

    public void prikaziIznos() {
        iznos.visibleProperty().setValue(true);
        iznosPorez.visibleProperty().setValue(true);
    }

    public void izadji() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Izlaz");
        alert.setHeaderText(null);
        alert.setContentText("Da li ste sigurni da zelite da izadjete?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Platform.exit();
        }
    }
}
