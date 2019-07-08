import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GitHubAnalyzerGUI extends Application{

    FileLoader fileLoader;
    GitHubAnalyzer gitHubAnalyzer;


    private void createTableView(Stage stage, BorderPane borderPane) {

        TableView<Repository> table = new TableView<>();
        List<TableColumn<Repository, String>> tableColumns = new ArrayList<>();
        List<String> fieldNames = gitHubAnalyzer.getFieldNames();
        List<String> printableNames = gitHubAnalyzer.getPrintableFieldNames();
        for (int i = 0; i < fieldNames.size(); i++) {

            TableColumn<Repository, String> tableColumn = new TableColumn(printableNames.get(i));
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(fieldNames.get(i)));
            tableColumns.add(tableColumn);

        }

        table.getColumns().addAll(tableColumns);
        table.setItems(gitHubAnalyzer.getRepositories());
        VBox box = new VBox();
        borderPane.setBottom(box);
        borderPane.setCenter(table);

    }

    private void createMenu(Stage stage, BorderPane borderPane) {

        final Menu menuFile = new Menu("File");
        MenuItem MenuItemOpen = new MenuItem("Open");

        MenuItemOpen.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Chose .txt file");
                File file = fileChooser.showOpenDialog(stage);
                if (file != null) {

                    fileLoader = new FileLoader();
                    String path = file.getPath();
                    fileLoader.load(path);
                    gitHubAnalyzer.setCreateRepositories(fileLoader.getUrlList());
                    createTableView(stage, borderPane);

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

        menuFile.getItems().add(MenuItemOpen);
        menuFile.getItems().add(exit);

        final Menu menuTools = new Menu("Tools");
        MenuItem menuItemAnalyzer = new MenuItem("Commit menuItemAnalyzer");
        menuItemAnalyzer.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {

                if (fileLoader.isEmpty()){

                    return;

                }

                Task<Void> t = new Task<>() {

                    @Override
                    protected Void call(){

                        gitHubAnalyzer.getRepositories();
                        gitHubAnalyzer.printRepositories();
                        return null;

                    }

                    @Override
                    protected void succeeded() {

                        createTableView(stage, borderPane);

                    }

                };

                new Thread(t).start();

            }

        });

        menuTools.getItems().add(menuItemAnalyzer);
        final Menu menuAbout = new Menu("Help");
        MenuItem about = new MenuItem("About");
        about.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("About");
                alert.setContentText(" GitHubAnalyzer Dev. by Felipe Imhoff");
                alert.showAndWait();

            }

        });

        menuAbout.getItems().add(about);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuTools, menuAbout);
        borderPane.setTop(menuBar);

    }

    @Override
    public void start(Stage stage){

        gitHubAnalyzer = new GitHubAnalyzer();
        BorderPane root = new BorderPane();
        createMenu(stage, root);
        stage.setTitle("GitHubAnalyzer");
        stage.setScene(new Scene(root, 1800, 720));
        stage.show();

    }

}