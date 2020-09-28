package sample.DataModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.Iterator;

public class ClientData {
    private static ClientData instance = new ClientData();
    private static String fileName = "list.txt";

    private ObservableList<Client> clients;

    public static ClientData getInstance() {
        return instance;
    }

    public ObservableList<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void loadClients() throws IOException {
        clients = FXCollections.observableArrayList();
        String input;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((input = br.readLine()) != null) {
                String[] data = input.split("\t");

                String name = data[0];
                String company = data[1];
                String phone = data[2];

                Client client = new Client(name, company, phone);
                clients.add(client);
            }
        }
    }

    public void storeClients() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            Iterator<Client> iterator = clients.iterator();
            while (iterator.hasNext()) {
                Client client = iterator.next();
                bw.write(String.format("%s\t%s\t%s", client.getName(), client.getCompany(), client.getPhone()));
                bw.newLine();
            }
        }
    }

    public void deleteClient(Client client) {
        clients.remove(client);
    }
}
