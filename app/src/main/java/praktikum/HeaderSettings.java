package praktikum;

public class HeaderSettings {
    private String series;
    private String measurements;
    private String host;
    private Integer process;
    private String type;
    private Integer metric;
    private Integer sampling;
    private Integer aggregation;
    private long dateFrom;
    private long dateTo;

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

    public Integer getProcess() {
        return this.process;
    }

    public void setProcess(Integer process) {
        this.process = process;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMetric() {
        return this.metric;
    }

    public void setMetric(Integer metric) {
        this.metric = metric;
    }

    public Integer getSampling() {
        return this.sampling;
    }

    public void setSampling(Integer sampling) {
        this.sampling = sampling;
    }

    public Integer getAggregation() {
        return this.aggregation;
    }

    public void setAggregation(Integer aggregation) {
        this.aggregation = aggregation;
    }

    public long getDateFrom() {
        return this.dateFrom;
    }

    public void setDateFrom(long dateFrom) {
        this.dateFrom = dateFrom;
    }

    public long getDateTo() {
        return this.dateTo;
    }

    public void setDateTo(long dateTo) {
        this.dateTo = dateTo;
    }
}
