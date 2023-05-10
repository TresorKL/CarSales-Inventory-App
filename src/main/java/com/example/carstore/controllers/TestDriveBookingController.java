package com.example.carstore.controllers;

import com.example.carstore.entities.Car;
import com.example.carstore.entities.TestDriveBooking;
import com.example.carstore.services.TestDriveBookingServiceInterface;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TestDriveBookingController {

    @Autowired
    TestDriveBookingServiceInterface testDriveBookingServiceInterface;

    @PostMapping("/booktestdrive")
    public String newTestDriveBooking(HttpSession session, @RequestParam String testDriveDate, HttpServletRequest request) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date testDate = formatter.parse(testDriveDate);

        testDriveBookingServiceInterface.createTestDriveBooking(session,testDate);



        return "successful-booking";

    }
}
