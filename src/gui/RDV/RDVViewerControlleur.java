package gui.RDV;

import entity.Rendez_vous;
import gui.RDV.tableElement.RDVelement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import services.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RDVViewerControlleur implements Initializable {

    @FXML
    private TextField searchBox;
    @FXML
    private VBox pnItems;
    @FXML
    private Label nombre;



    Rendez_vous_service rs=new Rendez_vous_service();


    ObservableList<Rendez_vous> rendez_vousListe;
    public void refrechObservableListe() throws SQLException {
        rendez_vousListe.clear();
        for (Rendez_vous v:  rs.recuperer()){
            v.getHeure_rendez_vous();
        }
        rendez_vousListe= (ObservableList<Rendez_vous>) rs.recuperer();
        remplirliste(rendez_vousListe);
    }
    public void remplirliste(ObservableList<Rendez_vous> rendez_vousListe){
        nombre.setText(String.valueOf(rendez_vousListe.size()));
        nodes=new ArrayList<>();
        if(rendez_vousListe.size()>=1){
            for (int i = 0; i < rendez_vousListe.size(); i++) {
                try {

                    final int j = i;
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("tableElement/itemRendezvou.fxml"));

                    nodes.add(  loader.load());
                    RDVelement element=loader.getController();
                    element.setListener(new RDVelement.PopupListener() {
                        @Override
                        public void onInfoSent(Rendez_vous rendez_vousInstance, String Action) {
                            pnItems.getChildren().clear();
                            if (Action=="Modify"){
                                try {
                                    System.out.println("rani klena");
                                    refrechObservableListe();

                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }

                            }else {
                                rendez_vousListe.remove(rendez_vousInstance);
                                remplirliste(rendez_vousListe);
                            }

                }
                    });
                    element.setValues(rendez_vousListe.get(i));
                    //give the items some effect


                    pnItems.getChildren().add(nodes.get(i));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            pnItems.getChildren().removeAll();


        }
    }


    @FXML
    void triNomAnnonce(MouseEvent event) {
        FXCollections.sort(rendez_vousListe, new CompareProjetName());
        pnItems.getChildren().removeAll();
        pnItems.getChildren().clear();
        remplirliste(rendez_vousListe);
    }


    @FXML
    void rechercher(KeyEvent event) {

        FilteredList<Rendez_vous> filterData = new FilteredList<>(rendez_vousListe, p -> true);
        searchBox.textProperty().addListener((obsevable, oldvalue, newvalue) -> {
            filterData.setPredicate(rendez_vous -> {
                if (newvalue == null || newvalue.isEmpty()) {

                    return true;
                }
                String typedText = newvalue.toLowerCase();
                if (String.valueOf(rendez_vous.getProjet().getTitre()).toLowerCase().indexOf(typedText) != -1) {

                    return true;
                }if (String.valueOf(rendez_vous.getUser().getNom()).toLowerCase().indexOf(typedText) != -1) {

                    return true;
                }
                return false;
            });

            SortedList<Rendez_vous> sortedList = new SortedList<>(filterData);
            // sortedList.comparatorProperty().bind(pnItems.);
            pnItems.getChildren().clear();

            remplirliste(sortedList);

            // table.setItems(sortedList);


        });

    }
    ArrayList<Node> nodes;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            rendez_vousListe= (ObservableList<Rendez_vous>) rs.recuperer();
            remplirliste(rendez_vousListe);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }






}
