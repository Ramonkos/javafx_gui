package praktikum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqliteController {
    private HeaderSettings headerSettings;

    public SqliteController(HeaderSettings headerSettings) {
        this.headerSettings = headerSettings;
    }

    ArrayList<DataSet> getData() {
        Connection connection = null;

        ArrayList<DataSet> dataSetList = new ArrayList<>();

        try {
            String url = "jdbc:sqlite:data.db"; // data.db file must be in app folder
            connection = DriverManager.getConnection(url);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String queryString = "select * from data where true" +
                    getQueryStringPart("series", headerSettings.getSeries()) +
                    getQueryStringPart("measurement", headerSettings.getMeasurements()) +
                    getQueryStringPart("host", headerSettings.getHost()) +
                    getQueryStringPart("process", headerSettings.getProcess()) +
                    getQueryStringPart("type", headerSettings.getType()) +
                    getQueryStringPart("metric", headerSettings.getMetric()) +
                    getQueryStringPart("sampling", headerSettings.getSampling()) +
                    getQueryStringPart("aggregation", headerSettings.getAggregation()) +
                    getQueryStringDateFrom(headerSettings.getDateFrom()) +
                    getQueryStringDateTo(headerSettings.getDateTo());

            System.out.println("queryString: " + queryString);
            ResultSet resultSet = statement.executeQuery(queryString);

            while (resultSet.next()) {
                DataSet dataSet = new DataSet();
                dataSet.setSeries(resultSet.getString("series"));
                dataSet.setMeasurements(resultSet.getString("measurement"));
                dataSet.setHost(resultSet.getString("host"));
                dataSet.setProcess(resultSet.getString("process"));
                dataSet.setType(resultSet.getString("type"));
                dataSet.setMetric(resultSet.getString("metric"));
                dataSet.setSampling(resultSet.getString("sampling"));
                dataSet.setAggregation(resultSet.getString("aggregation"));
                dataSet.setDate(resultSet.getString("date"));
                dataSet.setValue(resultSet.getString("value"));
                dataSetList.add(dataSet);
            }
        } catch (SQLException e) {
            // if the error message is "out of memory", it probably means no database file
            // is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return dataSetList;
    }

    private String getQueryStringPart(String attribute, String value) {
        return value == null ? "" : " and " + attribute + " = \"" + value + "\"";
    }

    private String getQueryStringPart(String attribute, Integer value) {
        return value == null ? "" : " and " + attribute + " = " + value;
    }

    private String getQueryStringDateFrom(long value) {
        System.out.println("getQueryStringDateFrom value: " + value);
        return value == 0L ? "" : " and date >= " + value;
    }

    private String getQueryStringDateTo(long value) {
        System.out.println("getQueryStringDateTo value: " + value);
        return value == 0L ? "" : " and date <= " + value;
    }
}