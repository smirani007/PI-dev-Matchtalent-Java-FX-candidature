package gui.RDV.Modify_RDV;

import entity.User;
import entity.Rendez_vous;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.Rendez_vous_service;

import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class ModifyRDVControlleur implements Initializable {
private  Boolean succes=false ;
    @FXML
    private Text erroraria;
    @FXML
    private ChoiceBox<Integer> CB1;
    @FXML
    private Button modify_Button;
    @FXML
    private Button closeButton;
    @FXML
    private ChoiceBox<Integer> CB2;

    @FXML
    private DatePicker date_Picker;
    private int[] a = IntStream.range(1, 30).toArray();
    Rendez_vous rdv;


    public interface ModifyListener {
        void onInfoSentModify( Rendez_vous rendez_vousInstance);
    }
    private ModifyListener listener;

    public void setModifyListner(ModifyListener listener) {
        this.listener = listener;
    }

    public void setAttribute(Rendez_vous v){
    this.rdv=v;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = dateFormat.format(rdv.getDate_rendez_vous());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);


        date_Picker.setValue(localDate);
       String[] heure= rdv.getHeure_rendez_vous().split(":");
        CB1.setValue(Integer.valueOf(heure[0]));
        CB2.setValue(Integer.valueOf(heure[1]));

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i=8;i<18;i++) {
            CB1.getItems().add(i);
        }
        for (int i=0;i<60;i++) {
            CB2.getItems().add(i);
        }
        CB2.setValue(9);
        CB1.setValue(8);
    }


    @FXML
    void modify(ActionEvent event) throws SQLException {
        LocalDate localDate = LocalDate.now();
        Rendez_vous_service rs=new Rendez_vous_service();
        if(date_Picker.getValue()==null){
            erroraria.setText("entrez une date s'il vous plait");
        }else{

            Date res=Date.from(date_Picker.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            String time=(CB1.getValue())+":"+(CB2.getValue()).toString();

            if((((date_Picker).getValue()).isAfter(localDate))&&(rs.getSpecified(new Rendez_vous(res,time,rdv.getProjet())).size()==0)){

                rs.modifier(new Rendez_vous(rdv.getId_rendez_vous(), new User(rdv.getUser().getId_user()),res,time,rdv.getProjet()));
                if (listener != null) {
                    listener.onInfoSentModify(rdv);
                }
                Stage stage = (Stage) modify_Button.getScene().getWindow();
                stage.close();

            }else erroraria.setText("vous avez entrez une date deja existant");}
    }
    @FXML
    void clickClose(ActionEvent event) {
        Stage stage = (Stage) modify_Button.getScene().getWindow();
        stage.close();
    }
    @FXML
    void changedDate() {
        LocalDate localDate = LocalDate.now();
        if(((date_Picker).getValue()).isAfter(localDate)){
            erroraria.setText("");

            succes=true;
}else {            erroraria.setText("vous avez entrez une date invalid");
            succes=false;
    }}

    /*public void setValues(candidature candidatureInstance){
       c=candidatureInstance;
        }*/



}
