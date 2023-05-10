package com.example.carstore.services;

import com.example.carstore.entities.Car;
import com.example.carstore.entities.Customer;
import com.example.carstore.entities.TestDriveBooking;
import com.example.carstore.repositories.TestDriveBookingRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TestDriveBookingServiceImpl implements TestDriveBookingServiceInterface{

    @Autowired
    TestDriveBookingRepo testDriveBookingRepo;

    @Override
    public List<TestDriveBooking> getTestDriveBookings() {
        return testDriveBookingRepo.findAll();
    }

    @Override
    public TestDriveBooking createTestDriveBooking(HttpSession session, Date testDriveDate) {

        TestDriveBooking testDriveBooking= new TestDriveBooking();
        Customer customer =(Customer) session.getAttribute("customer");
        Car car = (Car)session.getAttribute("product");
        testDriveBooking.setTestDriveDate(testDriveDate);
        testDriveBooking.setCustomer(customer);
        testDriveBooking.setCar(car);

        return testDriveBookingRepo.save(testDriveBooking);

    }
}
