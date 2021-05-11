package MyThreading.view.resources.controllers;

import MyThreading.logic.View;
import javafx.fxml.*;
import MyThreading.logic.TableData;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MenuBarController {

    @FXML private MenuItem tableStartBtn;
    @FXML private MenuItem tableStopBtn;
    @FXML private MenuItem tableClearBtn;

    private TableData tableData;
    private View view;

    private static ExecutorService executorService;
    private boolean isLoading = false;

    public void initialize(){
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
        ButtonType b1 = new ButtonType("I'm completely blind");
        ButtonType b2 = new ButtonType("I don't know how to follow directions");

        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Blind?");
        alert.setHeaderText("");
        alert.setContentText("Can't you read? There is no help here. \r\n Please answer the question!");

        alert.getButtonTypes().addAll(b1,b2);

        alert.show();
    }
}
