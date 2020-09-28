package sample.DataModel;

import javafx.beans.property.SimpleStringProperty;

public class Client {
    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty company = new SimpleStringProperty("");
    private SimpleStringProperty phone = new SimpleStringProperty("");

    public Client(String name, String company, String phone) {
        this.name.set(name);
        this.company.set(company);
        this.phone.set(phone);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getCompany() {
        return company.get();
    }

    public SimpleStringProperty companyProperty() {
        return company;
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }
}
