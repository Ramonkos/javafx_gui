package praktikum;

public class DataSet {
    private String series;
    private String measurements;
    private String host;
    private String process;
    private String type;
    private String metric;
    private String sampling;
    private String aggregation;
    private String date;
    private String value;

    public String getSeries() {
        return this.series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMeasurements() {
        return this.measurements;
    }

    public void setMeasurements(String measurements) {
        this.measurements = measurements;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getProcess() {
        return this.process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMetric() {
        return this.metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getSampling() {
        return this.sampling;
    }

    public void setSampling(String sampling) {
        this.sampling = sampling;
    }

    public String getAggregation() {
        return this.aggregation;
    }

    public void setAggregation(String aggregation) {
        this.aggregation = aggregation;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
