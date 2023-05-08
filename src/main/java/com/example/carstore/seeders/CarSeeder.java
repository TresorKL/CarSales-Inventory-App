package com.example.carstore.seeders;

import com.example.carstore.entities.Car;
import com.example.carstore.repositories.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarSeeder implements CommandLineRunner {

    @Autowired
     CarRepo carRepository;

    public CarSeeder(CarRepo carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public void run(String... args) throws Exception {
//        List<Car> cars = new ArrayList<>();
//        cars.add(new Car("Toyota", "Corolla", "A sedan car", 2019, 15000.00, 10));
//        cars.add(new Car("Honda", "Civic", "A sedan car", 2018, 14000.00, 8));
//        cars.add(new Car("Ford", "Fiesta", "A hatchback car", 2017, 12000.00, 5));
//        cars.add(new Car("Chevrolet", "Cruze", "A sedan car", 2020, 18000.00, 12));
//        cars.add(new Car("Volkswagen", "Golf", "A hatchback car", 2019, 17000.00, 6));
//        cars.add(new Car("Nissan", "Sentra", "A sedan car", 2017, 13000.00, 9));
//        cars.add(new Car("BMW", "3 Series", "A sedan car", 2021, 35000.00, 3));
//        cars.add(new Car("Mercedes-Benz", "C-Class", "A sedan car", 2018, 28000.00, 7));
//        cars.add(new Car("Audi", "A4", "A sedan car", 2020, 32000.00, 5));
//        cars.add(new Car("Tesla", "Model S", "An electric car", 2019, 70000.00, 2));
//        cars.add(new Car("Hyundai", "Elantra", "A sedan car", 2018, 11000.00, 4));
//        cars.add(new Car("Kia", "Optima", "A sedan car", 2019, 14000.00, 6));
//        cars.add(new Car("Subaru", "Impreza", "A hatchback car", 2020, 18000.00, 4));
//        cars.add(new Car("Mazda", "Mazda3", "A sedan car", 2017, 13000.00, 8));
//        cars.add(new Car("Lexus", "ES", "A sedan car", 2021, 40000.00, 3));
//        cars.add(new Car("Infiniti", "Q50", "A sedan car", 2019, 25000.00, 5));
//        cars.add(new Car("Porsche", "911", "A sports car", 2020, 95000.00, 1));
//        cars.add(new Car("Ferrari", "488 GTB", "A sports car", 2018, 250000.00, 1));
//        cars.add(new Car("Lamborghini", "Aventador", "A sports car", 2021, 500000.00, 1));
//        cars.add(new Car("McLaren", "720S", "A sports car", 2020, 300000.00, 1));
//
//        carRepository.saveAll(cars);
    }
}
