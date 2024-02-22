import java.time.LocalDate;

public class CityHistoryService extends CityHistory{

    public CityHistoryService(Integer historicalDataId, Integer cityId, LocalDate eventDate, Integer historicalTemperature, Integer historicalHumidity, Integer historicalWindSpeed) {
        super(historicalDataId, cityId, eventDate, historicalTemperature, historicalHumidity, historicalWindSpeed);
    }
}
