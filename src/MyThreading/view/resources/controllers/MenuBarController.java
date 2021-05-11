package MyThreading.view.resources.controllers;

import MyThreading.MainApp;
import MyThreading.logic.View;
import javafx.fxml.*;
import MyThreading.logic.TableData;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MenuBarController {

    @FXML private MenuItem tableStartBtn;
    @FXML private MenuItem tableStopBtn;
    @FXML private MenuItem tableClearBtn;

    private Scene rootScene;

    private TableData tableData;
    private View view;

    private static ExecutorService executorService;
    private boolean isLoading = false;

    public void initialize(){
        view = new View();
        clearUI();
    }


    @FXML private void startLoadingTable(ActionEvent actionEvent) {
        tableData = new TableData();
        isLoading = true;

        tableStartBtn.setDisable(true);
        tableStopBtn.setDisable(false);
        tableClearBtn.setDisable(false);

        executorService = Executors.newSingleThreadExecutor();
        executorService.submit(tableData);
    }

    @FXML private void stopLoadingTable(ActionEvent actionEvent) {
        tableData.cancel();
        isLoading = false;

        clearUI();
        tableClearBtn.setDisable(false);
    }

    @FXML private void clearTable(ActionEvent actionEvent) {
        tableData.getPersonList().clear();
        tableData.setCurrentid(1);
        clearUI();
    }

    private void clearUI() {
        if (isLoading) {
            tableStartBtn.setDisable(true);
            tableStopBtn.setDisable(false);
            tableClearBtn.setDisable(false);
        } else if (!isLoading){
            tableStartBtn.setDisable(false);
            tableStopBtn.setDisable(true);
            tableClearBtn.setDisable(true);
        }
    }

    public void startLoadingArea(ActionEvent actionEvent) {
    }

    public void stopLoadingArea(ActionEvent actionEvent) {
    }

    public void clearArea(ActionEvent actionEvent) {
    }

    public void noHelpHere(ActionEvent actionEvent) {
        Scene scene = view.getPrimaryScene();
        scene.getRoot().setRotate(180);

    }
}
