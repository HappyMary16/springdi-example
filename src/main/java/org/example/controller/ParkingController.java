package org.example.controller;

import org.example.model.Car;
import org.example.service.ParkingService;
import org.example.service.StatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Опрацьовує HTTP запити.
 */
@RestController
public class ParkingController {

    private final ParkingService parkingService;
    private final StatisticService statisticService;

    /**
     * Конструктор класу.
     *
     * @param parkingService
     * @param statisticService
     */
    public ParkingController(ParkingService parkingService, StatisticService statisticService) {
        this.parkingService = parkingService;
        this.statisticService = statisticService;
    }

    /**
     * Опрацьовує POST запит, який додає автомобіль на парковку.
     * <p>
     * Запит:
     * <pre>
     * POST http://localhost:8080/cars
     * Content-Type: application/json
     *
     * {
     *   "carNumber": "AA1111AA"
     * }
     * </pre>
     *
     * @param car автомобіль, який треба припаркувати
     * @return true - якщо автомобіль вдалося припаркувати,
     * false - якщо на парковці не було місця для автомобіля
     */
    @PostMapping ("/cars")
    boolean parkCar(@RequestBody Car car) {
        return parkingService.parkCar(car);
    }

    /**
     * Опрацьовує GET запит, який повертає кількість
     * автомобілів на парковці в даний момент часу.
     * <p>
     * Запит:
     * <pre>
     * GET http://localhost:8080/amount-of-cars
     * </pre>
     *
     * @return кількість автомобілів на парковці
     */
    @GetMapping("/amount-of-cars")
    int getAmountOfCars() {
        return statisticService.getAmountOfCars();
    }
}
