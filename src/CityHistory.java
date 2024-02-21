import java.time.LocalDate;

public class CityHistory {
    private Integer historicalDataId;
    private Integer cityId;
    private LocalDate eventDate;
    private Integer historicalTemperature;
    private Integer historicalHumidity;
    private Integer historicalWindSpeed;
    public CityHistory(Integer historicalDataId, Integer cityId, LocalDate eventDate, Integer historicalTemperature, Integer historicalHumidity, Integer historicalWindSpeed) {
        this.historicalDataId = historicalDataId;
        this.cityId = cityId;
        this.eventDate = eventDate;
        this.historicalTemperature = historicalTemperature;
        this.historicalHumidity = historicalHumidity;
        this.historicalWindSpeed = historicalWindSpeed;
    }
}
