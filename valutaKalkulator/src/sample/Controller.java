package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.ArrayList;


class Valuta{

    public String sort;
    public Double kurs;

    //Standard constructor

    public Valuta(String sort, double kurs){
        this.sort = sort;
        this.kurs = kurs;
    }


}

class Kalkulator{

    int [] valutas = new Valuta()


    public void fyllListe(){
        Valuta forstValuta = new Valuta("USD", 9.8);
        Valuta andreValuta= new Valuta("EUR", 10.2);
        Valuta tredjeValuta = new Valuta("ASD", 13);

        valutas.add(forstValuta);
        valutas.add(andreValuta);
        valutas.add(tredjeValuta);

    }

    public String beregn(String valuta, String belop){

        try {
            Double inVerdi = Double.parseDouble(belop);
            Double innValuta = Double.parseDouble(valuta);
            double valutaVerdi = inVerdi *innValuta;
            DecimalFormat df = new DecimalFormat("####0.00");

            return " Beregner beløp blir " + df.format(valutaVerdi);

        }catch (NumberFormatException e){
            return "Feil verdi, må være tall";
        }
    }

}



public class Controller {

    Kalkulator wiilwaal = new Kalkulator();


    public TextField txtBelop;
    public TextField txtValuta;
    public Label lblResult;

    public void regnUt(ActionEvent event) {
        wiilwaal.fyllListe();
      String ut =  wiilwaal.beregn(txtValuta.getText(), txtBelop.getText());

      lblResult.setText(ut);


    }
}
