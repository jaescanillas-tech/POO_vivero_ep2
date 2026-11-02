package cl.duoc.vivero.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainController {

    public static final String TIPO_INTERIOR = "Interior";
    public static final String TIPO_EXTERIOR = "Exterior";

    // Datos comunes
    @FXML private ChoiceBox<String> tipoPlantaChoice;
    @FXML private TextField nombrePlanta;
    @FXML private TextField alturaPlanta;
    @FXML private Spinner<Integer> cantidadPlanta;

    // Datos planta interior
    @FXML private AnchorPane ventanaPlantaInt;
    @FXML private TextField volumenMaceta;

    // Planta Exterior
    @FXML private AnchorPane ventanaPlantaExt;
    @FXML private TextField especie;
    @FXML private CheckBox resistehielo;
    @FXML private CheckBox despacho;


    @FXML
    private void initialize() {
        tipoPlantaChoice.getItems().addAll(TIPO_INTERIOR, TIPO_EXTERIOR);
        ventanaPlantaInt.setVisible(false);
        ventanaPlantaExt.setVisible(false);
        tipoPlantaChoice.valueProperty().addListener((observable, oldValue, newValue) -> {
            actualizarCampos();
        });

    }

    private void actualizarCampos() {
        actualizarPorTipo();
    }

    private void actualizarPorTipo(){
        boolean interior = tipoPlantaChoice.getValue().equals(TIPO_INTERIOR);
        boolean exterior = tipoPlantaChoice.getValue().equals(TIPO_EXTERIOR);

        ventanaPlantaInt.setVisible(!interior);
        ventanaPlantaExt.setVisible(!exterior);
    }
}
