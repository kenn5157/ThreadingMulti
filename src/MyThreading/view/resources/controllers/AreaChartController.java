package MyThreading.view.resources.controllers;

import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AreaChartController implements Initializable {

    public AreaChart areaChart;

    public CategoryAxis categoryAxis;
    public NumberAxis numberAxis;
    public AnchorPane rootPane;

    private void dataset2020(){
        XYChart.Series data = new XYChart.Series();
        data.setName("2020");

        data.getData().add(new XYChart.Data("Jan", 20));
        data.getData().add(new XYChart.Data("Feb", 51));
        data.getData().add(new XYChart.Data("Mar", 56));
        data.getData().add(new XYChart.Data("Apr", 47));
        data.getData().add(new XYChart.Data("May", 23));
        data.getData().add(new XYChart.Data("Jun", 48));
        data.getData().add(new XYChart.Data("Jul", 64));
        data.getData().add(new XYChart.Data("Aug", 54));
        data.getData().add(new XYChart.Data("Sep", 45));
        data.getData().add(new XYChart.Data("Oct", 32));
        data.getData().add(new XYChart.Data("Nov", 94));
        data.getData().add(new XYChart.Data("Dec", 87));


        areaChart.getData().add(data);
    }

    private void dataset2019(){
        XYChart.Series data = new XYChart.Series();
        data.setName("2019");

        data.getData().add(new XYChart.Data("Jan", 54));
        data.getData().add(new XYChart.Data("Feb", 13));
        data.getData().add(new XYChart.Data("Mar", 31));
        data.getData().add(new XYChart.Data("Apr", 64));
        data.getData().add(new XYChart.Data("May", 45));
        data.getData().add(new XYChart.Data("Jun", 65));
        data.getData().add(new XYChart.Data("Jul", 87));
        data.getData().add(new XYChart.Data("Aug", 12));
        data.getData().add(new XYChart.Data("Sep", 45));
        data.getData().add(new XYChart.Data("Oct", 56));
        data.getData().add(new XYChart.Data("Nov", 85));
        data.getData().add(new XYChart.Data("Dec", 73));


        areaChart.getData().add(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numberAxis.setLabel("Stonks");
        categoryAxis.setLabel("Month");

        dataset2020();
        dataset2019();

        rootPane.setStyle("-fx-background-color: white");
    }
}
