package MyThreading;

import MyThreading.logic.View;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp extends Application {

    private View view = new View();

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hello World!");
        this.primaryStage.setOnCloseRequest(e -> {
            System.exit(0);
        });

        view.setPrimaryStage(this.primaryStage);

        initRootLayout();

        loadView("menuBar", "^");
        loadView("tableView", "<--");
        loadView("areaChart", "--");
    }

    private void initRootLayout(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout, 1000, 600);
            view.setPrimaryScene(scene);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    private void loadView(String fxml, String location){
        Task<AnchorPane> task = new Task<AnchorPane>() {
            @Override
            protected AnchorPane call() throws Exception {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("view/resources/" + fxml + ".fxml"));
                AnchorPane anchorPane = loader.load();
                return anchorPane;
            }
        };

        task.setOnSucceeded(e -> {
            switch (location) {
                case "<--" -> rootLayout.setLeft(task.getValue());
                case "--" -> rootLayout.setCenter(task.getValue());
                case "-->" -> rootLayout.setRight(task.getValue());
                case "^" -> rootLayout.setTop(task.getValue());
            }
        });

        task.setOnFailed(e -> {
            task.getException().printStackTrace();
        });

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(task);
        executorService.shutdown();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args){
        launch(args);
    }
}
