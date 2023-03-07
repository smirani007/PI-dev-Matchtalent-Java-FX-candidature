package gui.Demande.PopupInformation;

import entity.Demande;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class detailControlleur implements Initializable {

    @FXML
    private Label phonenumber;

    @FXML
    private Label email;

    @FXML
    private Label id;
    @FXML
    private Label contact;
    @FXML
    private Label name;
    @FXML
    private Label note;
    private Demande u;
    @FXML
    private GridPane grid;

Demande c;
    public void setDialogPane(Demande u){
        this.c=u;
        System.out.println("test1"+u.getUtilisateur().getNom()+u.getUtilisateur().getprénom());
        System.out.println("test2"+u.getUtilisateur().getMail());
        System.out.println("test3"+u.getUtilisateur().getAdresse());
        System.out.println("test4"+String.valueOf(u.getUtilisateur().getGrad()));
        System.out.println("test5"+String.valueOf((u.getUtilisateur().getNuméroTéléphone())));
        System.out.println("test6");
    name.setText(u.getUtilisateur().getNom()+" "+u.getUtilisateur().getprénom());
    email.setText(u.getUtilisateur().getMail());
    contact.setText(u.getUtilisateur().getAdresse());
    note.setText(String.valueOf(u.getUtilisateur().getGrad()));
        phonenumber.setText(String.valueOf((u.getUtilisateur().getNuméroTéléphone())));
        int longeur =0;


}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

}
}
