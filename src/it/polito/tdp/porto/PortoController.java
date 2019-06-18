package it.polito.tdp.porto;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.porto.model.Author;
import it.polito.tdp.porto.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class PortoController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Author> boxPrimo;

    @FXML
    private ComboBox<Author> boxSecondo;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleCoautori(ActionEvent event) {
    	Author a = boxPrimo.getValue();
    	
    	if(a==null) {
    		txtResult.setText("Selezionare un autore");
    		return;
    	}
    	
    	model.creaGrafo();
    	
    	for(Author c : model.getCoautori(a))
    		txtResult.appendText(c.toString() + "\n");
   
    }

    @FXML
    void handleSequenza(ActionEvent event) {

    }

    public void setModel(Model model) {
    	this.model=model;
    	boxPrimo.getItems().addAll(this.model.getAllAutori());
    	boxSecondo.getItems().addAll(this.model.getAllAutori());
    }
    
    @FXML
    void initialize() {
        assert boxPrimo != null : "fx:id=\"boxPrimo\" was not injected: check your FXML file 'Porto.fxml'.";
        assert boxSecondo != null : "fx:id=\"boxSecondo\" was not injected: check your FXML file 'Porto.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Porto.fxml'.";

    }
}
