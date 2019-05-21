package it.polito.tdp.dizionariograph;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioGraphController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtnumerolettere;

    @FXML
    private TextField txtparoladacercare;

    @FXML
    private Button btngeneragrafo;

    @FXML
    private Button btnTrovavicini;

    @FXML
    private Button btnTrovagrafomax;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doGrafo(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doTovagrafomax(ActionEvent event) {

    }

    @FXML
    void doTrovavicini(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtnumerolettere != null : "fx:id=\"txtnumerolettere\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtparoladacercare != null : "fx:id=\"txtparoladacercare\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btngeneragrafo != null : "fx:id=\"btngeneragrafo\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnTrovavicini != null : "fx:id=\"btnTrovavicini\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnTrovagrafomax != null : "fx:id=\"btnTrovagrafomax\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";

    }
}
