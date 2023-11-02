package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class CalculatorController {

    @FXML
    private TextField displayTxt;
    private String number1 = "";
    private String pivote = "";
    private String operation;
    @FXML
    private Text savedNumbers;

    // Tipo de operacion que se desea ingrear
    @FXML
    void addOperation(ActionEvent event) {
        calculationSetup("+");
    }
    @FXML
    void divideOperation(ActionEvent event) {
        calculationSetup("/");
    }
    @FXML
    void miltiplicationOperation(ActionEvent event) {
        calculationSetup("*");
    }
    @FXML
    void minusOperation(ActionEvent event) {
        calculationSetup("-");
    }

    // Digitamos los numeros
    @FXML
    void button1Clicked(MouseEvent event) {
        addNumber("1");
    }
    @FXML
    void button2Clicked(MouseEvent event) {
        addNumber("2");
    }

    @FXML
    void button3Clicked(MouseEvent event) {
        addNumber("3");
    }

    @FXML
    void button4Clicked(MouseEvent event) {
        addNumber("4");
    }

    @FXML
    void button5Clicked(MouseEvent event) {
        addNumber("5");
    }

    @FXML
    void button6Clicked(MouseEvent event) {
        addNumber("6");
    }

    @FXML
    void button7Clicked(MouseEvent event) {
        addNumber("7");
    }

    @FXML
    void button8Clicked(MouseEvent event) {
        addNumber("8");
    }

    @FXML
    void button9Clicked(MouseEvent event) {
        addNumber("9");
    }
    @FXML
    void button0Clicked(MouseEvent event) {
        addNumber("0");
    }

    /**
     * Esta funcion sirve para concatenar los numeros de una o varias cifras
     * Ingresa un numero, este se convierte en el pivote, y si se ingresa otro numero, se le suma al numero pivote (es una suma de Strings)
     * @param number de tipo String
     */
    private void addNumber(String number) {
        pivote += number;
        actualizarDisplay();
    }

    /**
     * Esta funcion se llama despues de haber ingresado el primer numero y una vez seleccionado la operacion a realizar
     * Lo primero que hace es guardar el tipo de operacion
     * guarda el numero que se genero en el addNumber y lo coloca a la atributo de la clase number1
     * resetea el pivote
     * Imprime en pantalla el number1 y la operacion seleccionada
     * @param op
     */
    private void calculationSetup(String op) {
        this.operation = op;
        number1 = pivote;
        pivote="";
        savedNumbers.setText(number1 + "" + operation);
    }

    /**
     * Esta funcion limpia todos los datos en pantalla
     * @param event
     */
    @FXML
    void clearTxtField(ActionEvent event) {
        pivote = "";
        displayTxt.setText("");
        savedNumbers.setText("");
    }

    /**
     * Esta funcion actualiza el numero ingresado en pantalla
     */
    private void actualizarDisplay() {
        displayTxt.setText("    "+this.pivote);
    }

    /**
     * Esta funcion sirve para realizar todas las operaciones
     * recopila todos los datos anteriores, numeros y operaciones seleccionadas
     * @param event
     */
    @FXML
    void calculate(ActionEvent event) {
        try{
            int num1 = Integer.parseInt(number1);
            int num2 = Integer.parseInt(pivote);
            int result = 0;
            switch (this.operation){
                case "+":
                    result = num1 + num2;
                    savedNumbers.setText(num1 + " + " + num2 );
                    displayTxt.setText("                                         " + result + "");
                    break;
                case "-":
                    result = num1 - num2;
                    savedNumbers.setText(num1 + " - " + num2 );
                    displayTxt.setText("                                         " + result + "");
                    break;
                case "*":
                    result = num1 * num2;
                    savedNumbers.setText(num1 + " * " + num2 );
                    displayTxt.setText("                                         " + result + "");
                    break;
                case "/":
                        double resultado = (double) num1 / num2;
                        savedNumbers.setText(num1 + " / " + num2 );
                        displayTxt.setText("                                  " + resultado + "");
                    break;
            }
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
            //System.out.println("Exception for: "+e.getMessage());
        }
    }

}
