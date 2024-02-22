public abstract class City {
    private Integer cityId;
    private String cityName;
    private Integer currentTemperature;
    private Integer currentHumidity;
    private Integer currentWindSpeed;

    public City(Integer cityId, String cityName, Integer currentTemperature, Integer currentHumidity, Integer currentWindSpeed) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.currentTemperature = currentTemperature;
        this.currentHumidity = currentHumidity;
        this.currentWindSpeed = currentWindSpeed;
    }

    public Integer getCityId() {

        return cityId;
    }

    public void setCityId(Integer cityId) {

        this.cityId = cityId;
    }

    public String getCityName() {

        return cityName;
    }

    public void setCityName(String cityName) {

        this.cityName = cityName;
    }

    public Integer getCurrentTemperature() {

        return currentTemperature;
    }

    public void setCurrentTemperature(Integer currentTemperature) {

        this.currentTemperature = currentTemperature;
    }

    public Integer getCurrentHumidity() {

        return currentHumidity;
    }

    public void setCurrentHumidity(Integer currentHumidity) {

        this.currentHumidity = currentHumidity;
    }

    public Integer getCurrentWindSpeed() {

        return currentWindSpeed;
    }

    public void setCurrentWindSpeed(Integer currentWindSpeed) {

        this.currentWindSpeed = currentWindSpeed;
    }
    public abstract void addCity();
    public abstract void updateCity();
    public abstract void deleteCity();
    public abstract void searchCity();
    public abstract void displayCity();

    public String toString() {
        return "+----------- Ville id : " + cityId + " ----------+\n" +
                "- name : " + cityName + "\n" +
                "- Temperature : " + currentTemperature + " °C\n" +
                "- Humidity : " + currentHumidity + " %\n" +
                "- Wind Speed : " + currentWindSpeed + " Km/h\n" +
                "+-------------------------------------+";
    }
}
