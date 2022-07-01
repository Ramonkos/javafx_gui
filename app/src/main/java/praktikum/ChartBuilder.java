package praktikum;

import java.util.ArrayList;

import javafx.util.StringConverter;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class ChartBuilder {
    private ArrayList<DataSet> dataSetList;
    private float lowestValue = 0;
    private float highestValue = 0;
    private float smallestDate = System.currentTimeMillis();
    private float highestDate = 0;
    private float tickUnit = 1;

    public ChartBuilder(ArrayList<DataSet> dataSetList) {
        this.dataSetList = dataSetList;
    }

    LineChart<Number, Number> initChart() {
        setLowestAndHighestValueAndDate();
        DateConverter dateConverter = new DateConverter();

        NumberAxis xAxis = new NumberAxis(smallestDate, highestDate, tickUnit);
        xAxis.setAutoRanging(false);
        xAxis.setTickLabelFormatter(new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return dateConverter.getLocalDateStringFromTimeStamp(object.longValue());
            }

            @Override
            public Number fromString(String string) {
                return null;
            }
        });

        NumberAxis yAxis = new NumberAxis(lowestValue, highestValue, 10);
        xAxis.setLabel("Date");
        yAxis.setLabel("Value");

        LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
        series.setName("Value on Date");

        for (int index = 0; index < dataSetList.size(); index += 1) {
            DataSet dataSet = dataSetList.get(index);

            String valueStr = dataSet.getValue();
            String dateStr = dataSet.getDate();

            float value = Float.parseFloat(valueStr);
            long date = Long.parseLong(dateStr);

            series.getData().add(new XYChart.Data<Number, Number>(date, value));
        }

        lineChart.getData().add(series);

        return lineChart;
    }

    private void setLowestAndHighestValueAndDate() {
        for (int index = 0; index < dataSetList.size(); index += 1) {
            DataSet dataSet = dataSetList.get(index);
            float value = Float.parseFloat(dataSet.getValue());
            long date = Long.parseLong(dataSet.getDate());

            if (value > highestValue) {
                highestValue = value;
            }

            if (date < smallestDate) {
                smallestDate = date;
            }

            if (date > highestDate) {
                highestDate = date;
            }

            tickUnit = (highestDate - smallestDate) / (dataSetList.size() >= 1 ? dataSetList.size() : 1);
        }
    }
}
