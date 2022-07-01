package praktikum;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;

public class HeaderController implements Initializable {
    HeaderSettings headerSettings = new HeaderSettings();
    DateConverter dateConverter = new DateConverter();

    @FXML
    ComboBox<String> seriesComboBox;

    @FXML
    ComboBox<String> measurementsComboBox;

    @FXML
    ComboBox<String> hostComboBox;

    @FXML
    ComboBox<Integer> processComboBox;

    @FXML
    ComboBox<String> typeComboBox;

    @FXML
    ComboBox<Integer> metricComboBox;

    @FXML
    ComboBox<Integer> samplingComboBox;

    @FXML
    ComboBox<Integer> aggregationComboBox;

    @FXML
    DatePicker dateFromPicker;

    @FXML
    DatePicker dateToPicker;

    @FXML
    VBox vBox;

    @FXML
    void onSeriesAction(ActionEvent event) {
        headerSettings.setSeries(seriesComboBox.getValue());
    }

    @FXML
    void onMeasurements(ActionEvent event) {
        headerSettings.setMeasurements(measurementsComboBox.getValue());
    }

    @FXML
    void onHost(ActionEvent event) {
        headerSettings.setHost(hostComboBox.getValue());
    }

    @FXML
    void onProcess(ActionEvent event) {
        headerSettings.setProcess(processComboBox.getValue());
    }

    @FXML
    void onType(ActionEvent event) {
        headerSettings.setType(typeComboBox.getValue());
    }

    @FXML
    void onMetric(ActionEvent event) {
        headerSettings.setMetric(metricComboBox.getValue());
    }

    @FXML
    void onSampling(ActionEvent event) {
        headerSettings.setSampling(samplingComboBox.getValue());
    }

    @FXML
    void onAggregation(ActionEvent event) {
        headerSettings.setAggregation(aggregationComboBox.getValue());
    }

    @FXML
    void onDateFrom(ActionEvent event) {
        LocalDate date = dateFromPicker.getValue();
        long timeStamp = dateConverter.getTimeStampFromLocalDate(date);
        headerSettings.setDateFrom(timeStamp);
    }

    @FXML
    void onDateTo(ActionEvent event) {
        LocalDate date = dateToPicker.getValue();
        long timeStamp = dateConverter.getTimeStampFromLocalDate(date);
        headerSettings.setDateTo(timeStamp);
    }

    @FXML
    void onGenerateGraph(ActionEvent event) {
        SqliteController sqliteController = new SqliteController(headerSettings);
        ArrayList<DataSet> dataSetList = sqliteController.getData();
        System.out.println("dataSetList size: " + dataSetList.size());
        ChartBuilder chartBuilder = new ChartBuilder(dataSetList);
        LineChart<Number, Number> lineChart = chartBuilder.initChart();

        if (vBox.getChildren().size() > 1) {
            vBox.getChildren().remove(1);
        }

        vBox.getChildren().add(lineChart);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        seriesComboBox.getItems().setAll("old", "new");
        measurementsComboBox.getItems().setAll("fast", "intensive");
        hostComboBox.getItems().setAll("fcc", "ada", "jfc");
        processComboBox.getItems().setAll(0, 1);
        typeComboBox.getItems().setAll("max", "average");
        metricComboBox.getItems().setAll(0, 1);
        samplingComboBox.getItems().setAll(0, 1, 2);
        aggregationComboBox.getItems().setAll(0, 1, 2);
    }
}
