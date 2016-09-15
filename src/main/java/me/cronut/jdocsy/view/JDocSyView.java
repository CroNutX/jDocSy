package me.cronut.jdocsy.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Author cronut
 * Date 14.09.16
 */
public class JDocSyView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(
                FXMLLoader.load(getClass().getClassLoader().getResource("fxml/jdocsy.fxml")),
                1024,
                576);

        stage.setResizable(false);
        stage.setTitle("jDocSy");
        stage.setScene(scene);
        stage.show();
    }
}
