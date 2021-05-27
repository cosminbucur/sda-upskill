package com.sda.weather.info.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Metrics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "average_pressure")
    private Long averagePressure;
    @Column(name = "average_humidity")
    private Long averageHumidity;
    @Column(name = "average_wind_speed")
    private Long averageWindSpeed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    public Metrics() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getAveragePressure() {
        return averagePressure;
    }

    public void setAveragePressure(Long averagePressure) {
        this.averagePressure = averagePressure;
    }

    public Long getAverageHumidity() {
        return averageHumidity;
    }

    public void setAverageHumidity(Long averageHumidity) {
        this.averageHumidity = averageHumidity;
    }

    public Long getAverageWindSpeed() {
        return averageWindSpeed;
    }

    public void setAverageWindSpeed(Long averageWindSpeed) {
        this.averageWindSpeed = averageWindSpeed;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
