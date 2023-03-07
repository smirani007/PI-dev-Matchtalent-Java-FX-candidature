package gui.SideBar;


import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SideBarControlleur {
    @FXML
    private BorderPane mainPane;

    @FXML
    private VBox sidebar;
    @FXML
    private ImageView img;
    @FXML
    private StackPane content;

    private Map<String, Node> pages = new HashMap<>();

    @FXML
    private void initialize() throws IOException {
        // Set the first page as the content
        content.getChildren().add(loadPage("../Demande/Candidature.fxml"));
    }
    @FXML
    void closePage(MouseEvent event) {
        Stage stage = (Stage) img.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void loadPage1() throws IOException {
        loadPageToContent("../Demande/Candidature.fxml");
    }

    @FXML
    private void loadPage2() throws IOException {
        loadPageToContent("../RDV/RDV_Viewer.fxml");
    }


    private void loadPageToContent(String pageName) throws IOException {
        // Remove any existing content from the content region
        content.getChildren().clear();

        // Add the new content to the content region
        content.getChildren().add(loadPage(pageName));
    }

    private Node loadPage(String fxmlFileName) throws IOException {
        URL fxmlUrl = getClass().getResource(fxmlFileName);
        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        return loader.load();
    }
}