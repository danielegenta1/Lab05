package it.polito.tdp.anagrammi.controller;


import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private Button txtReset;
    
    private Model model;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) 
    {	
    	String input = txtInput.getText();
    	pulizia();
    	//string valida
    	if (input.compareTo("") != 0 && input.matches("[a-zA-Z]+"))
    	{
    		Set<String> allAnagrammi = model.allAnagrammi(input);
    		
    		//anagrammi validi
    		for (String s : allAnagrammi)
    		{
    			if (model.isValida(s))
    				txtAnagrammiCorretti.appendText(s + "\n"); 
    			else
    				txtAnagrammiErrati.appendText(s + "\n"); 
    		}
    	}
    	else
    	{
    		System.err.println("La stringa deve avere un formato alfabetico!");
    	}
    }

    @FXML
    void doReset(ActionEvent event)
    {
    	pulizia();
    	
    }

	private void pulizia()
	{
		txtInput.clear();
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
		
	}

	public void setModel(Model model)
	{
		this.model = model;
	}

}
