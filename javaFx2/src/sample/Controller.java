package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class Bil {


    public String bilNummer;
    public Date startTid;
    public int plass;
    public boolean kortTid;

    public Bil(String bilNummer, Date startTid, boolean kortTid) {
        this.bilNummer = bilNummer;
        this.startTid = startTid;
        this.kortTid = kortTid;
    }

    public  String formaterKvittering() {
        String startDatoTid = new SimpleDateFormat("dd.MM.YYYY HH:mm").format(startTid);
        String nå = new SimpleDateFormat("dd.MM.YYYY HH:mm").format(new Date());
        String ut = " ";
        ut += "Kvittering for " + bilNummer + "\n";
        ut += "Start tid " + startDatoTid;
        ut += nå;
        ut += "Betalt" + avgift();

        return ut;

    }

    public double getPris() {
        if (kortTid) {
            return 20;
        } else {
            return 0;
        }

    }

    public double avgift() {
        Date nå = new Date();
        long varighet = nå.getTime() - startTid.getTime();

        int  varigTid = (int)varighet / 10000;
       double pris = varigTid * getPris();

       return pris;
    }


}

class ParkeringHus {

  public   ArrayList<Bil> biler = new ArrayList<>();


    public void reserverPlass(Bil enBil) {
        biler.add(enBil);

    }

    public String frigjørPlass(String bilNummeret) {

        for (Bil enBil : biler) {


            if (enBil.bilNummer.equals(bilNummeret)) {


               biler.remove(enBil);


            }
            return enBil.formaterKvittering();

        }

        return "fant ikke  bilen";


    }

}

public class Controller {



    @FXML
    public TextField txtBilNummer;
    @FXML
    public Label lblLabel;
    @FXML
    public Button btnKortTid;
    @FXML
    public Button btnLangTid;
    @FXML
    public Button kjørUt;


    ParkeringHus wiilwaal = new ParkeringHus();


    public void kortTid(ActionEvent event) {
        Date nå = new Date();
        Bil enBil = new Bil(txtBilNummer.getText(), nå, true);

        wiilwaal.reserverPlass(enBil);

    }


    public void langTid(ActionEvent event) {
        Date nå = new Date();
        Bil enBil = new Bil(txtBilNummer.getText(), nå, false);

        wiilwaal.reserverPlass(enBil);


    }

    public void kjørUt(ActionEvent event) {

        String melding  =  wiilwaal.frigjørPlass(txtBilNummer.getText());

        lblLabel.setText(melding);


    }
}

