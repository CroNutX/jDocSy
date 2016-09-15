package me.cronut.jdocsy.core;

import javafx.scene.control.TreeCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.File;

/**
 * Author cronut
 * Date 14.09.16
 */
public class FileTreeCell extends TreeCell<File> {

    private HBox hbox;

    public FileTreeCell() {
        super();
    }

    @Override
    public void updateItem(File file, boolean empty) {
        super.updateItem(file, empty);
        updateDisplay(file, empty);
    }

    void updateDisplay(File file, boolean empty) {
        if (file == null || empty) {
            hbox = null;
            setText(null);
            setGraphic(null);
        } else {
            FileTreeItem treeItem = (FileTreeItem) getTreeItem();
            if (treeItem != null) {
                setText(file.getName());

                if(file.isDirectory()) {
                    setGraphic(
                            new ImageView(
                                    getClass().getClassLoader().getResource("icons/folder.png").toExternalForm()
                            )
                    );
                }
                else {
                    setGraphic(
                            new ImageView(getClass().getClassLoader().getResource("icons/file.png").toExternalForm()
                            )
                    );
                }
            }
        }
    }
}
