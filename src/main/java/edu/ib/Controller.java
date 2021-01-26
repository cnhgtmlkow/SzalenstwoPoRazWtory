package edu.ib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;

import static edu.ib.DystrybucjaKart.talia;

public class Controller {

    @FXML
    private Label karta2;

    @FXML
    private Label karta3;

    @FXML
    private Label karta1;

    @FXML
    private Label karta4;

    @FXML
    private Label karta5;

    @FXML
    private Label karta6;

    @FXML
    private Label karta7;

    @FXML
    private Label karta8;

    @FXML
    private Button rozdanie;

    @FXML
    private Label karta21;

    @FXML
    private Label karta31;

    @FXML
    private Label karta11;

    @FXML
    private Label karta41;

    @FXML
    private Label karta51;

    @FXML
    private Label karta61;

    @FXML
    private Label karta71;

    @FXML
    private Label karta81;

    void Gracz1(ActionEvent event) {
//      karta1.setText(Karta.toString());
    }
    void roz(ActionEvent event) {
        ArrayList<Karta> qw = new ArrayList<Karta>();
        Karta aktywna = new Karta("", "");
        Gracz gracz1 = new Gracz(qw);
        Gracz gracz2 = new Gracz(qw);
        Gracz[] gracze = {gracz1, gracz2};
        Stol stol = new Stol(qw, qw, aktywna);
        DystrybucjaKart.rozdanie(DystrybucjaKart.talia(), 2, gracze, stol);

    }


}