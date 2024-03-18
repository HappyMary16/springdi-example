package org.example.service;

import org.example.db.ParkingDb;
import org.example.model.Car;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * Відповідальний за всі дії, які можуть відбуватися на парковці:
 * <pre>
 * - паркування автомобілів
 * - видалення автомобілів з парковки
 * </pre>
 */
@Service
public class ParkingService {

    private final ParkingDb parkingDb;
    private final int parkingSize = 10;

    /**
     * Конструктор класу.
     *
     * @param parkingDb
     */
    public ParkingService(ParkingDb parkingDb) {
        this.parkingDb = parkingDb;
    }

    /**
     * Додає автомобіль на парковку, якщо ще є вільне місце.
     *
     * @param car автомобіль, який треба припаркувати
     * @return true - якщо автомобіль вдалося припаркувати,
     * false - якщо на парковці не було місця для автомобіля
     */
    public boolean parkCar(Car car) {
        if (parkingDb.getAmountOfCars() == parkingSize) {
            return false;
        }

        parkingDb.addCar(new Car(car.getCarNumber(), Instant.now()));
        return true;
    }

    /**
     * Видаляє автомобіль з парковки.
     *
     * @param carNumber номер автомобіля, який потрібно видалити
     */
    public void removeCar(String carNumber) {
       parkingDb.removeCar(carNumber);
    }
}
