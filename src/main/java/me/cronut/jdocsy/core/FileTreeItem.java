package me.cronut.jdocsy.core;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

import java.io.File;

/**
 * Author cronut
 * Date 14.09.16
 */
public class FileTreeItem extends TreeItem<File> {
    private boolean isLeaf;
    private boolean isFirstTimeChildren = true;
    private boolean isFirstTimeLeaf = true;

    public FileTreeItem(File file) {
        super(file);
    }

    @Override
    public ObservableList<TreeItem<File>> getChildren() {
        if (isFirstTimeChildren) {
            isFirstTimeChildren = false;
            super.getChildren().setAll(buildChildren(this));
        }
        return super.getChildren();
    }

    @Override
    public boolean isLeaf() {
        if (isFirstTimeLeaf) {
            isFirstTimeLeaf = false;
            File file = getValue();
            isLeaf = file.isFile();
        }
        return isLeaf;
    }

    private ObservableList<FileTreeItem> buildChildren(
            FileTreeItem TreeItem) {
        File file = TreeItem.getValue();
        if (file == null) {
            return FXCollections.emptyObservableList();
        }
        if (file.isFile()) {
            return FXCollections.emptyObservableList();
        }
        File[] files = file.listFiles();
        if (files != null) {
            ObservableList<FileTreeItem> children = FXCollections
                    .observableArrayList();
            for (File childFile : files) {
                children.add(new FileTreeItem(childFile));
            }
            return children;
        }
        return FXCollections.emptyObservableList();
    }
}
