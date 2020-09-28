package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.DataModel.Client;
import sample.DataModel.ClientData;

public class AddDialog {
    @FXML
    private TextField nameField;

    @FXML
    private TextField companyField;

    @FXML
    private TextField phoneField;

    public Client addClient() {
        String name = nameField.getText();
        String company = companyField.getText();
        String phone = phoneField.getText();


        Client client = new Client(name, company, phone);
        ClientData.getInstance().addClient(client);
        return client;
    }
}
