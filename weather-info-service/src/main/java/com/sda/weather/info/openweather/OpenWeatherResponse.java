package com.sda.weather.info.openweather;

public class OpenWeatherResponse {

    private String id;
    private String name;
    private Main main;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", main=" + main +
                '}';
    }
}
