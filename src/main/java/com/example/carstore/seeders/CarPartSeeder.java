package com.example.carstore.seeders;

import com.example.carstore.entities.CarPart;
import com.example.carstore.repositories.CarPartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarPartSeeder implements CommandLineRunner {

     @Autowired
     CarPartRepo  carPartRepository;

    @Autowired
    public CarPartSeeder(CarPartRepo carPartRepository) {
        this.carPartRepository = carPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        if (carPartRepository.count() == 0) {
//
//            List<CarPart> carParts = new ArrayList<>();
//
//            carParts.add(new CarPart("Brake Pads", "High performance brake pads for all weather conditions",
//                    "Brembo", "https://example.com/brembo.jpg", 89.99, 10));
//            carParts.add(new CarPart("Air Filter", "Reusable air filter for improved engine performance",
//                    "K&N", null, 49.99, 20));
//            carParts.add(new CarPart("Spark Plugs", "Platinum spark plugs for smoother acceleration and better fuel efficiency",
//                    "NGK", "https://example.com/ngk.jpg", 29.99, 30));
//            carParts.add(new CarPart("Oil Filter", "High quality oil filter to keep your engine running smoothly",
//                    "Mann-Filter", "https://example.com/mann-filter.jpg", 12.99, 50));
//            carParts.add(new CarPart("Tire Pressure Monitor Sensor", "Wireless sensor to monitor tire pressure",
//                    "Schwaben", null, 29.99, 15));
//            carParts.add(new CarPart("LED Headlight Bulbs", "Brighter and longer lasting LED headlight bulbs",
//                    "Philips", "https://example.com/philips.jpg", 79.99, 10));
//            carParts.add(new CarPart("Coilovers", "Adjustable coilover suspension kit for sporty handling and ride comfort",
//                    "KW Suspensions", "https://example.com/kw-suspensions.jpg", 799.99, 5));
//            carParts.add(new CarPart("Exhaust System", "Stainless steel cat-back exhaust system for improved performance and sound",
//                    "Borla", "https://example.com/borla.jpg", 699.99, 5));
//            carParts.add(new CarPart("Cold Air Intake", "High flow cold air intake system for increased horsepower and torque",
//                    "Injen", null, 199.99, 10));
//            carParts.add(new CarPart("Racing Seats", "Lightweight and supportive racing seats for improved comfort and performance",
//                    "Sparco", "https://example.com/sparco.jpg", 499.99, 5));
//            carParts.add(new CarPart("Short Shifter", "Short throw shifter for quicker and more precise gear changes",
//                    "Cobb Tuning", null, 149.99, 15));
//            carParts.add(new CarPart("Lithium Car Battery", "Lightweight and powerful lithium car battery",
//                    "Braille Battery", "https://example.com/braille-battery.jpg", 249.99, 10));
//
//            carPartRepository.saveAll(carParts);
//        }
    }
}
