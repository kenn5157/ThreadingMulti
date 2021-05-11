package MyThreading.view.resources.controllers;

import MyThreading.be.Person;
import MyThreading.logic.TableData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TableViewController {

    @FXML private TableView tableView;

    private ObservableList<Person> personList;

    private TableData tableData;

    public void initialize(){
        tableData = new TableData();

        personList = FXCollections.observableArrayList();
        tableView.setItems(personList);
        setTableView();

        tableData.setTableView(tableView);
        tableData.setPersonList(personList);
        tableData.setCurrentid(1);
    }

    private void setTableView(){
        tableView.setPrefWidth(400);

        tableView.setEditable(true);

        TableColumn first_name = new TableColumn("First Name");
        first_name.prefWidthProperty().bind(tableView.widthProperty().multiply(.49));
        first_name.setCellValueFactory(new PropertyValueFactory<String, String>("first_name"));

        TableColumn last_name = new TableColumn("Last Name");
        last_name.prefWidthProperty().bind(tableView.widthProperty().multiply(.49));
        last_name.setCellValueFactory(new PropertyValueFactory<String, String>("last_name"));

        tableView.getColumns().addAll(first_name, last_name);

        tableView.setEditable(false);
    }

}
