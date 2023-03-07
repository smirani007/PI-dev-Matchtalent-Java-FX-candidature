package gui.RDV.tableElement;

import entity.Demande;
import entity.Rendez_vous;
import gui.RDV.Modify_RDV.ModifyRDVControlleur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.StageStyle;
import services.Rendez_vous_service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class RDVelement {

    @FXML
    private Label contact;

    @FXML
    private HBox itemC;

    @FXML
    private Label mail;
    @FXML
    private Label address;
    @FXML
    private Label name;


    @FXML
    private Label note;
    @FXML
    private Label username;
    @FXML
    private Label date;
    @FXML
    private Label heure;
    Rendez_vous rendez_vousInstance;
    Rendez_vous_service rs=new Rendez_vous_service();

    public interface PopupListener {
        void onInfoSent(Rendez_vous rendez_vousInstance, String Action);
    }
    private PopupListener listener;

    public void setListener(PopupListener listener) {
        this.listener = listener;
    }

    public  void  setValues(Rendez_vous c){
        this.rendez_vousInstance =c;
        name.setText(c.getProjet().getTitre());
        date.setText(String.valueOf(c.getDate_rendez_vous()));
        heure.setText(String.valueOf(c.getHeure_rendez_vous()));
        username.setText(c.getUser().getNom());
    }
    @FXML
    void modierRDV(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("../Modify_RDV/ModifyRDVPopup.fxml"));
        DialogPane  detailPage=loader.load();
        ModifyRDVControlleur detailControlleur =loader.getController();
        detailControlleur.setModifyListner(new ModifyRDVControlleur.ModifyListener() {
                @Override
                public void onInfoSentModify( Rendez_vous rendez_vousInstance) {
                    if (listener != null) {
                        listener.onInfoSent(rendez_vousInstance,"Modify");
                    }
                }

        });
        detailControlleur.setAttribute(rendez_vousInstance);
        Dialog<ButtonType> dialog =new Dialog<>();
        dialog.initStyle(StageStyle.UNDECORATED);

        dialog.setDialogPane(detailPage);
        Optional<ButtonType> clickButtonp=dialog.showAndWait();
        dialog.setTitle("detail");
    }

    @FXML
    void supprimerAnnonce() throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression rendez-vous");

        alert.setContentText("la suppression implique le refus de condidature");
alert.setHeaderText("voulez vous supprimer un rendez-vous");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            {
                rs.supprimer(rendez_vousInstance);

        if (listener != null) {
            listener.onInfoSent(rendez_vousInstance,"supprimer");
        }

    }}}




}
