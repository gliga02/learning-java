package sample;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import java.util.function.Predicate;


public class OdlicniUceniciController {
    @FXML
    private ListView<Ucenik> listView;

    private Predicate<Ucenik> odlicniUcenici;

    public void initialize() {
        odlicniUcenici = new Predicate<Ucenik>() {
            @Override
            public boolean test(Ucenik ucenik) {
                return ucenik.getProsek() >= 4.5;
            }
        };
    }

    public void izdvojiOdlicne(ObservableList<Ucenik> ucenici) {
        FilteredList<Ucenik> filteredList = new FilteredList<>(ucenici, odlicniUcenici);
        if (filteredList.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Nema odlicnih ucenika");
            alert.setHeaderText(null);
            alert.setContentText("Trenutno nema odlicnih ucenika u tabeli");
            alert.showAndWait();
        }

        listView.getItems().addAll(filteredList);
    }
}
