package MyThreading.view.resources.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class PieViewController {

    @FXML private PieChart pieChart;

    private ObservableList<PieChart.Data> list;

    public void initialize(){
        list = FXCollections.observableArrayList();

        list.add(new PieChart.Data("Vandalism", 23.2));
        list.add(new PieChart.Data("Low Quality", 19.4));
        list.add(new PieChart.Data("Acceptable", 46.5));
        list.add(new PieChart.Data("Better than Avrage", 10.3));
        list.add(new PieChart.Data("Excelent", 0.6));

        pieChart.setData(list);
    }

}
