package eu.szestkam.cryptotraining.app;

import eu.szestkam.cryptotraining.AtBash.AtBashCiper;
import eu.szestkam.cryptotraining.cesar.CesarCipher;
import eu.szestkam.cryptotraining.matrix.MatrixCipher;
import eu.szestkam.cryptotraining.rot_13.Rot13;
import eu.szestkam.cryptotraining.vigenere.VigenereCipher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller{

    @FXML
    private Button StartButton;

    @FXML
    private TextField TextFieldToProcess;

    @FXML
    private TextField TextFieldResult;

    @FXML
    private RadioButton RBCesar;

    @FXML
    private RadioButton RBRot13;

    @FXML
    private RadioButton RBAtBash;

    @FXML
    private RadioButton RBVigenere;

    @FXML
    private RadioButton RBMatrix;

    @FXML
    void runStart(ActionEvent event) {
        if (RBCesar.isSelected()){
            CesarCipher cipher = new CesarCipher("abc");
        }else if (RBRot13.isSelected()){
            Rot13 rot13 = new Rot13("abc");
        } else if (RBAtBash.isSelected()){
            AtBashCiper atBashCiper = new AtBashCiper("abc");
        } else if (RBVigenere.isSelected()){
            VigenereCipher vigenereCipher = new VigenereCipher("abac");
        }else {
            MatrixCipher matrixCipher = new MatrixCipher("abac");
        }

    }

    @FXML
    void setAtBash(ActionEvent event) {

    }

    @FXML
    void setCesar(ActionEvent event) {

    }

    @FXML
    void setMatrix(ActionEvent event) {

    }

    @FXML
    void setRot13(ActionEvent event) {

    }

    @FXML
    void setVigenere(ActionEvent event) {

    }

    @FXML
    void textProcess(ActionEvent event) {

    }

    @FXML
    void textResult(ActionEvent event) {

    }

}
