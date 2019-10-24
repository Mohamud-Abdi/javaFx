package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.util.Random;


class KodeGenerator {

    private int[] kodeArray;
    private Random r = new Random();
    private int nyKodeIndeks = 0;


    public KodeGenerator(int antall) {

        this.kodeArray = new int[antall];
        genererKoder();

    }


    private void genererKoder() {

        for(int i = 0; i < kodeArray.length; i++){
            kodeArray[i] = 100000 + r.nextInt(999999);
        }

    }

    public String nyKode (int maksAntall) {

        if (nyKodeIndeks < maksAntall) {


            return Integer.toString(kodeArray[nyKodeIndeks++]);


        } else {
            return "feil margin";
        }
    }

    public String formatBrukteKoder() {

        String ut = " ";

        for (int i = 0; i < nyKodeIndeks; i++) {

            ut += kodeArray[i] + "\n";


        }

        return ut;
    }


}


public class Controller {
    public final int MAKS_ANTALL = 10;

   private KodeGenerator test = new KodeGenerator(MAKS_ANTALL );


    public Label lblNyKode;
    public Label lblGamleKoder;

    public void generateNyKode(ActionEvent event) {
;
        lblNyKode.setText(test.nyKode(MAKS_ANTALL));


    }

    public void gamleKoderList(ActionEvent event) {
lblGamleKoder.setText(test.formatBrukteKoder());

    }
}
