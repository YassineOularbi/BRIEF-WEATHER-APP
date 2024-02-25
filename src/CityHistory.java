import java.time.LocalDate;

public class CityHistory {
    private Integer historicalDataId;
    private Integer cityId;
    private LocalDate eventDate;
    private Integer historicalTemperature;
    private Integer historicalHumidity;
    private Integer historicalWindSpeed;
    private String cityName;
    public CityHistory() {
        this.historicalDataId = null;
        this.cityId = null;
        this.eventDate = null;
        this.historicalTemperature = null;
        this.historicalHumidity = null;
        this.historicalWindSpeed = null;
        this.cityName = null;
    }

    public Integer getHistoricalDataId() {

        return historicalDataId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    @Override
    public String toString() {
        return "+----------- Historique Id : " + historicalDataId + " ----------+\n" +
                "- Ville Id : " + cityId + "\n" +
                "- Nom : " + cityName + "\n" +
                "- Date de l'événement : " + eventDate + "\n" +
                "- Température historique : " + historicalTemperature + " °C\n" +
                "- Humidité historique : " + historicalHumidity + " %\n" +
                "- Vitesse du vent historique : " + historicalWindSpeed + " Km/h\n" +
                "+-------------------------------------+";
    }

}
