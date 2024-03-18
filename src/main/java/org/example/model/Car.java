package org.example.model;

import java.time.Instant;

public class Car {

    private String carNumber;
    private Instant parkingTime;

    public Car() {
    }

    public Car(String carNumber, Instant parkingTime) {
        this.carNumber = carNumber;
        this.parkingTime = parkingTime;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public Instant getParkingTime() {
        return parkingTime;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void setParkingTime(Instant parkingTime) {
        this.parkingTime = parkingTime;
    }
}
