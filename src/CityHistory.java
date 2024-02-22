import java.time.LocalDate;

public abstract class CityHistory {
    private Integer historicalDataId;
    private Integer cityId;
    private LocalDate eventDate;
    private Integer historicalTemperature;
    private Integer historicalHumidity;
    private Integer historicalWindSpeed;
    public CityHistory() {
        this.historicalDataId = null;
        this.cityId = null;
        this.eventDate = null;
        this.historicalTemperature = null;
        this.historicalHumidity = null;
        this.historicalWindSpeed = null;
    }

    public Integer getHistoricalDataId() {

        return historicalDataId;
    }

    public void setHistoricalDataId(Integer historicalDataId) {

        this.historicalDataId = historicalDataId;
    }

    public Integer getCityId() {

        return cityId;
    }

    public void setCityId(Integer cityId) {

        this.cityId = cityId;
    }

    public LocalDate getEventDate() {

        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {

        this.eventDate = eventDate;
    }

    public Integer getHistoricalTemperature() {

        return historicalTemperature;
    }

    public void setHistoricalTemperature(Integer historicalTemperature) {
        this.historicalTemperature = historicalTemperature;
    }

    public Integer getHistoricalHumidity() {

        return historicalHumidity;
    }

    public void setHistoricalHumidity(Integer historicalHumidity) {

        this.historicalHumidity = historicalHumidity;
    }

    public Integer getHistoricalWindSpeed() {

        return historicalWindSpeed;
    }

    public void setHistoricalWindSpeed(Integer historicalWindSpeed){
        this.historicalWindSpeed = historicalWindSpeed;
    }
}
