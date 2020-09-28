package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddController {
    @FXML
    private TextField textFieldIme;

    @FXML
    private TextField textFieldPrezime;

    @FXML
    private TextField textFieldProsek;

    public Ucenik noviUcenik() {
        String ime = textFieldIme.getText();
        String prezime = textFieldPrezime.getText();
        double prosek = Double.parseDouble(textFieldProsek.getText());

        Ucenik ucenik = new Ucenik(ime, prezime, prosek);
        UcenikModel.getInstance().unesiUcenika(ucenik);
        return ucenik;
    }

    public void izmeniUcenika(Ucenik ucenik) {
        textFieldIme.setText(ucenik.getIme());
        textFieldPrezime.setText(ucenik.getPrezime());
        textFieldProsek.setText(String.valueOf(ucenik.getProsek()));
    }

    public void apdejtujUcenika(Ucenik ucenik) {
        ucenik.setIme(textFieldIme.getText());
        ucenik.setPrezime(textFieldPrezime.getText());
        ucenik.setProsek(Double.parseDouble(textFieldProsek.getText()));
    }

}
