package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<Ucenik> tableView;

    @FXML
    private TableColumn<Ucenik, String> imena;

    @FXML
    private TableColumn<Ucenik, String> prezimena;

    @FXML
    private TableColumn<Ucenik, Double> proseci;

    @FXML
    private RadioButton rastuci;

    @FXML
    private RadioButton opadajuci;

    @FXML
    private Button odlicni;


    private ObservableList<Ucenik> ucenici;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ucenici = FXCollections.observableArrayList();

        imena.setCellValueFactory(new PropertyValueFactory<>("Ime"));
        prezimena.setCellValueFactory(new PropertyValueFactory<>("Prezime"));
        proseci.setCellValueFactory(new PropertyValueFactory<>("Prosek"));

        tableView.setItems(UcenikModel.getInstance().getUcenici());
    }

    @FXML
    public void dodajUcenika() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(anchorPane.getScene().getWindow());
        dialog.setTitle("Unesi ucenika");
        dialog.setHeaderText("Uneiste novog ucenika");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            AddController addController = fxmlLoader.getController();
            Ucenik ucenik = addController.noviUcenik();
            ucenici.add(ucenik);
//            tableView.getItems().add(ucenik);
        }
    }

    @FXML
    public void izmeniUcenika() {
        Ucenik selektovaniUcenik = tableView.getSelectionModel().getSelectedItem();
        if (selektovaniUcenik == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ucenik nije selektovan");
            alert.setHeaderText(null);
            alert.setContentText("Molimo Vas, kliknite na ucenika koji zelite da izmenite.");
            alert.showAndWait();
            return;
        }

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(anchorPane.getScene().getWindow());
        dialog.setTitle("Izmeni ucenika");
        dialog.setHeaderText("Izmenite informacije");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        AddController addController = fxmlLoader.getController();
        addController.izmeniUcenika(selektovaniUcenik);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            addController.apdejtujUcenika(selektovaniUcenik);
            ucenici.remove(selektovaniUcenik);
            ucenici.add(selektovaniUcenik);
            UcenikModel.getInstance().izbrisiUcenika(selektovaniUcenik);
            UcenikModel.getInstance().unesiUcenika(selektovaniUcenik);
//            tableView.getItems().add(selektovaniUcenik);
        }
    }

    @FXML
    public void izbrisiUcenika() {
        Ucenik selektovaniUcenik = tableView.getSelectionModel().getSelectedItem();
        if (selektovaniUcenik == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ucenik nije selektovan");
            alert.setHeaderText(null);
            alert.setContentText("Molimo Vas, kliknite na ucenika koji zelite da obrisete.");
            alert.showAndWait();
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Brisanje ucenika");
        alert.setHeaderText(null);
        alert.setContentText("Da li ste sigurni da zelite da obrisete ucenika " + selektovaniUcenik.getIme() + " " + selektovaniUcenik.getPrezime());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ucenici.remove(selektovaniUcenik);
            UcenikModel.getInstance().izbrisiUcenika(selektovaniUcenik);
        }
    }


    @FXML
    public void sortiraj() {
        if (ucenici.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Greska");
            alert.setHeaderText(null);
            alert.setContentText("Nema dovoljno unetih ucenika za sortiranje");
            alert.showAndWait();
            return;
        }


        FilteredList<Ucenik> filteredList = new FilteredList<>(ucenici);

        if (rastuci.isSelected()) {
            SortedList<Ucenik> sortedList = new SortedList<>(filteredList, new Comparator<Ucenik>() {
                @Override
                public int compare(Ucenik o1, Ucenik o2) {
                    if (o1.getProsek() < o2.getProsek()) {
                        return -1;
                    } else if (o1.getProsek() > o2.getProsek()) {
                        return 1;
                    } else return 0;
                }
            });

            tableView.setItems(sortedList);
        }

        if (opadajuci.isSelected()) {
            SortedList<Ucenik> sortedList = new SortedList<>(filteredList, new Comparator<Ucenik>() {
                @Override
                public int compare(Ucenik o1, Ucenik o2) {
                    if (o1.getProsek() < o2.getProsek()) {
                        return 1;
                    } else if (o1.getProsek() > o2.getProsek()) {
                        return -1;
                    } else return 0;
                }
            });

            tableView.setItems(sortedList);
        }
    }

    public void prikaziOdlicne() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(anchorPane.getScene().getWindow());
        dialog.setTitle("Odlicni Ucenici");
        dialog.setHeaderText("Odlicni ucenici");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("odlicniUcenici.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }

        catch (IOException e) {
            System.out.println("Ne moze da se otvori prozor");
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        dialog.show();

        OdlicniUceniciController odlicniUceniciController = fxmlLoader.getController();
        odlicniUceniciController.izdvojiOdlicne(ucenici);
    }


    @FXML
    public void close() {
        Platform.exit();
    }
}
