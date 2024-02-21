public class City {
    private Integer cityId;
    private String cityName;
    private Integer currentTemperature;
    private Integer currentHumidity;
    private Integer currentWindSpeed;
    public City() {
        this.cityId = null;
        this.cityName = null;
        this.currentTemperature = null;
        this.currentHumidity = null;
        this.currentWindSpeed = null;
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
}
