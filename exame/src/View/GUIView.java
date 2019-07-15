package View;

import Controller.FileLoaderController;
import Controller.PersonListController;
import Model.PersonList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GUIView extends Application {

    PersonListController personListController;
    FileLoaderController fileLoaderController;

    @Override
    public void start(Stage stage) throws Exception {

        personListController = new PersonListController();

        BorderPane root = new BorderPane();
        createMenu(stage,root);
        stage.setTitle("Students Grades");
        stage.setScene(new Scene(root,1280,700));
        stage.show();

    }


    private void createMenu(Stage stage, BorderPane root) {

        final Menu file = new Menu("File");
        MenuItem load = new MenuItem("Load");
        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Chose a .csv file");
                File file = fileChooser.showOpenDialog(stage);
                if(file != null){

                    fileLoaderController = new FileLoaderController();
                    String path = file.getPath();
                    fileLoaderController.load(path);
                    personListController.setInititalPersons(fileLoaderController.getPersonList());
                    initTableView(stage, root);

                }
            }
        });

        MenuItem save = new MenuItem("Save");
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Chose a .csv file to written");
                    File file = fileChooser.showOpenDialog(stage);
                    FileWriter fileWriter = new FileWriter(file.getPath());
                    fileWriter.append("name;lastname;grade1;grade2");
                    for( PersonList p: personListController.getPersons()){

                        fileWriter.append("\n");
                        fileWriter.append(p.getName());
                        fileWriter.append(";");
                        fileWriter.append(p.getLastname());
                        fileWriter.append(";");
                        fileWriter.append(p.getGrade1());
                        fileWriter.append(";");
                        fileWriter.append(p.getGrade2());

                    }

                    fileWriter.flush();
                    fileWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });

        file.getItems().addAll(load,save,exit);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(file);
        root.setTop(menuBar);

    }

    private void initTableView(Stage stage, BorderPane root) {

        TableView<PersonList> tableView = new TableView<>();

        List<TableColumn<PersonList, String>> tableColumns = new ArrayList<>();
        List<String> printableNames = personListController.getFieldListPrintableNames();
        List<String> fieldNames = personListController.getFieldListNames();
        for (int i = 0; i < fieldNames.size(); i++) {
            TableColumn<PersonList, String> tableColumn = new TableColumn(printableNames.get(i));
            tableColumn.setCellValueFactory(new PropertyValueFactory<PersonList, String>(fieldNames.get(i)));
            tableColumns.add(tableColumn);
        }

        tableView.getColumns().addAll(tableColumns);
        tableView.setItems(personListController.getPersons());
        tableView.setEditable(true);

        TextField nameInput = new TextField();
        nameInput.setPromptText("Name");
        TextField lastNameInput = new TextField();
        lastNameInput.setPromptText("LastName");
        TextField grade1Input = new TextField();
        grade1Input.setPromptText("First Grade");
        TextField grade2Input = new TextField();
        grade2Input.setPromptText("Second Grade");

        Button add = new Button("Add");
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                String p = nameInput.getText()+';'+lastNameInput.getText()+';'+grade1Input.getText()+';'+grade2Input.getText();
                personListController.setPersonsList(p);
                nameInput.clear();
                lastNameInput.clear();
                grade1Input.clear();
                grade2Input.clear();

            }
        });
        Button delete = new Button("Delete");
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                ObservableList<PersonList> personSelected, allPersons;
                allPersons = tableView.getItems();
                personSelected = tableView.getSelectionModel().getSelectedItems();
                personSelected.forEach(allPersons::remove);

            }
        });

        tableColumns.get(0).setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumns.get(0).setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PersonList, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<PersonList, String> personListStringCellEditEvent) {

                int x = personListStringCellEditEvent.getTablePosition().getRow();
                personListController.getPersons().get(x).setName(personListStringCellEditEvent.getNewValue());

            }
        });

        tableColumns.get(1).setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumns.get(1).setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PersonList, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<PersonList, String> personListStringCellEditEvent) {

                int x = personListStringCellEditEvent.getTablePosition().getRow();
                personListController.getPersons().get(x).setLastname(personListStringCellEditEvent.getNewValue());

            }
        });

        tableColumns.get(2).setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumns.get(2).setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PersonList, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<PersonList, String> personListStringCellEditEvent) {

                int x = personListStringCellEditEvent.getTablePosition().getRow();
                personListController.getPersons().get(x).setGrade1(personListStringCellEditEvent.getNewValue());

            }
        });

        tableColumns.get(3).setCellFactory(TextFieldTableCell.forTableColumn());
        tableColumns.get(3).setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<PersonList, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<PersonList, String> personListStringCellEditEvent) {

                int x = personListStringCellEditEvent.getTablePosition().getRow();
                personListController.getPersons().get(x).setGrade2(personListStringCellEditEvent.getNewValue());

            }
        });

        VBox box = new VBox();
        box.getChildren().addAll(nameInput,lastNameInput,grade1Input,grade2Input,add,delete);
        root.setBottom(box);

        root.setCenter(tableView);
    }


}
