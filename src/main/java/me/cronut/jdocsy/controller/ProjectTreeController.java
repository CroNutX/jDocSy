package me.cronut.jdocsy.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeView;
import me.cronut.jdocsy.core.FileTreeCell;
import me.cronut.jdocsy.core.FileTreeItem;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Author cronut
 * Date 14.09.16
 */
public class ProjectTreeController implements Initializable {

    @FXML
    private TreeView projectTreeView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ButtonType loginButtonType = new ButtonType("Submit", ButtonBar.ButtonData.OK_DONE);
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Chose your project path:");
        dialog.setContentText("Please chose the path where your project is stored.");
        dialog.setHeaderText("Chose your project path:");
        dialog.getDialogPane().getButtonTypes().add(loginButtonType);
        boolean disabled = false;
        dialog.getDialogPane().lookupButton(loginButtonType).setDisable(disabled);
        Optional<String> projectPath;
        File projectDir = null;

        while(projectDir == null) {
            projectPath = dialog.showAndWait();

            if(projectPath.isPresent()) {
                try {
                    projectDir = new File(projectPath.get());
                } catch(Exception e) {
                    projectDir = null;
                    continue;
                }
            }
        }
        projectTreeView.setCellFactory(
                callback -> new FileTreeCell()
        );
        projectTreeView.setRoot(
                new FileTreeItem(projectDir)
        );
    }
}
