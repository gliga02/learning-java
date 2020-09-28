package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import sample.DataModel.Client;
import sample.DataModel.ClientData;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<Client, String> names;

    @FXML
    private TableColumn<Client, String> companies;

    @FXML
    private TableColumn<Client, String> phones;

    private ObservableList<Client> clients;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clients = FXCollections.observableArrayList();
//
        names.setCellValueFactory(new PropertyValueFactory<>("Name"));
        companies.setCellValueFactory(new PropertyValueFactory<>("Company"));
        phones.setCellValueFactory(new PropertyValueFactory<>("Phone"));

        tableView.setItems(ClientData.getInstance().getClients());
    }

    @FXML
    public void addClient() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(borderPane.getScene().getWindow());
        dialog.setTitle("Add Client");
        dialog.setHeaderText("Add New Client");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            AddDialog addDialog = fxmlLoader.getController();
            Client client = addDialog.addClient();
            clients.add(client);
        }
    }

    @FXML
    public void exit() {
        Platform.exit();
    }
}
