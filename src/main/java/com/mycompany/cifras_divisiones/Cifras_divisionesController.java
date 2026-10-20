package com.mycompany.cifras_divisiones;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class Cifras_divisionesController implements Initializable {

    @FXML
    private Button btnAnalizar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtCantidadCifras;
    @FXML
    private TextField txtSumaImpares;
    @FXML
    private TextField txtSumaPares;
    @FXML
    private TextField txtSumaTotal;
    @FXML
    private TextField txtCifraMayor;
    @FXML
    private TextField txtCifraMenor;
    @FXML
    private ListView listDivisores; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }    

    @FXML
    private void analizarNumero(ActionEvent event) {
        try {
            String textoNumero = txtNumero.getText().trim();
            if (textoNumero.isEmpty()) return;

            long numero = Long.parseLong(textoNumero);
            if (numero <= 0) return;
            
            int cantidadCifras = textoNumero.length();
            int sumaTotal = 0;
            int sumaPares = 0;
            int sumaImpares = 0;
            int mayor = -1;
            int menor = 10;

            for (int i = 0; i < cantidadCifras; i++) {
                int digito = Character.getNumericValue(textoNumero.charAt(i));

                sumaTotal += digito;

                if (digito % 2 == 0) {
                    sumaPares += digito;
                } else {
                    sumaImpares += digito;
                }

                if (digito > mayor) mayor = digito;
                if (digito < menor) menor = digito;
            }
            
            txtCantidadCifras.setText(String.valueOf(cantidadCifras));
            txtSumaImpares.setText(String.valueOf(sumaImpares));
            txtSumaPares.setText(String.valueOf(sumaPares));
            txtSumaTotal.setText(String.valueOf(sumaTotal));
            txtCifraMayor.setText(String.valueOf(mayor));
            txtCifraMenor.setText(String.valueOf(menor));
            
            ObservableList<String> divisores = FXCollections.observableArrayList();
            for (long i = 1; i <= numero; i++) {
                if (numero % i == 0) {
                    divisores.add(String.valueOf(i));
                }
            }
            listDivisores.setItems(divisores);

        } catch (NumberFormatException e) {
            limpiarCampos(event);
            txtNumero.setText("Error");
        }
    }

    @FXML
    private void limpiarCampos(ActionEvent event) {
        txtNumero.setText("");
        txtCantidadCifras.setText("");
        txtSumaImpares.setText("");
        txtSumaPares.setText("");
        txtSumaTotal.setText("");
        txtCifraMayor.setText("");
        txtCifraMenor.setText("");   
        listDivisores.getItems().clear();
        txtNumero.requestFocus();

    }
    
}
