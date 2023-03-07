package gui.Demande;

import entity.Demande;
import entity.Projet;
import gui.Demande.TableElement.elementController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.CompareNom;
import services.CompareNote;
import services.DemandeService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DemandeControlleur implements Initializable {

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private TextField searchBox;
    @FXML
    private VBox pnItems;
    @FXML
    private Label nombre;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private GridPane grid;
    @FXML
    private Pane pnlMenus;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;
    DemandeService cs=new DemandeService();


    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private ImageView imageView;



    @FXML
    private void onImageViewClicked() {
        comboBox.getItems().add("ffff");
        System.out.println("ffff");
        comboBox.setVisible(!comboBox.isVisible());
    }


    @FXML
    private ImageView img;
    @FXML
    void closePage(MouseEvent event) {
        Stage stage = (Stage) img.getScene().getWindow();
        stage.close();
    }

    ObservableList<Demande> DemandesListe;
    public void remplirliste(ObservableList<Demande> DemandesListe){
        nombre.setText(String.valueOf(DemandesListe.size()));
        nodes=new ArrayList<>();
        System.out.println(DemandesListe.size());
        if(DemandesListe.size()>=1){
            for (int i = 0; i < DemandesListe.size(); i++) {
                try {

                    final int j = i;
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("TableElement/Item.fxml"));

                    nodes.add(  loader.load());
                    elementController f=loader.getController();
                    f.setChangeListener(new elementController.PopupListener() {
                        @Override
                        public void onInfoSentChange( Boolean var) throws SQLException {
                            if (var) {
                                pnItems.getChildren().clear();

                                getFromDb();

                            }
                        }

                    });
                    f.setValues(DemandesListe.get(i));
                    //give the items some effect


                    pnItems.getChildren().add(nodes.get(i));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            pnItems.getChildren().removeAll();


        }
    }
    /*
    @FXML
    void moveToChart(ActionEvent event) throws IOException {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("../Chart/Barchart.fxml"));
        Parent root =loader.load();
        barChartControlleur send1 = loader.getController();

        send1.sendData(DemandesListe);
        pnlOverview.set setCenter(root);

        FXMLLoader loader =new FXMLLoader(getClass().getResource("../Chart/Barchart.fxml"));
        Pane root =loader.load();
        barChartControlleur send1 = loader.getController();

        send1.sendData(DemandesListe);
        pnlOverview.getChildren().setAll(root);



    }*/


    @FXML
    void triNote(MouseEvent event) {
        FXCollections.sort(DemandesListe, new CompareNote());
            pnItems.getChildren().removeAll();
            pnItems.getChildren().clear();
            remplirliste(DemandesListe);
    }
    @FXML
    void triUsername(MouseEvent event) {
        FXCollections.sort(DemandesListe, new CompareNom());
            pnItems.getChildren().removeAll();
            pnItems.getChildren().clear();
            remplirliste(DemandesListe);
    }


    @FXML
    void rechercher(KeyEvent event) {

        FilteredList<Demande> filterData = new FilteredList<>(DemandesListe, p -> true);
        searchBox.textProperty().addListener((obsevable, oldvalue, newvalue) -> {
            filterData.setPredicate(candida -> {
                if (newvalue == null || newvalue.isEmpty()) {

                    return true;
                }
                String typedText = newvalue.toLowerCase();
                if (String.valueOf(candida.getUtilisateur().getNom()).toLowerCase().indexOf(typedText) != -1) {

                    return true;
                }if (String.valueOf(candida.getUtilisateur().getNuméroTéléphone()).indexOf(typedText) != -1) {

                    return true;
                }
                return false;
            });
            pnItems.getChildren().removeAll();

            SortedList<Demande > sortedList = new SortedList<>(filterData);
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
            getFromDb();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void getFromDb() throws SQLException {

            DemandesListe= (ObservableList<Demande>) cs.recupererSuivantProjet(new Projet(1));
            remplirliste(DemandesListe);


    }


}
