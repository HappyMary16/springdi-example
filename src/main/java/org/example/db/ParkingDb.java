package org.example.db;

import org.example.model.Car;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Реалізація "in memory" бази даних в якій зберігаються автомобілі.
 *
 * @author mariia.borodin (mborodin)
 * @since 1.1
 */
@Repository
public class ParkingDb {

    private final Map<String, Car> cars = new HashMap<>();

    public void addCar(Car car) {
        cars.put(car.getCarNumber(), car);
    }

    public void removeCar(String carNumber) {
        cars.remove(carNumber);
    }

    public Collection<Car> getAllCars() {
        return cars.values();
    }

    public Car getCar(String carNumber) {
        return cars.get(carNumber);
    }

    public int getAmountOfCars() {
        return cars.size();
    }
}
