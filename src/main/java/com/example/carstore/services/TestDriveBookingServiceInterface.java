package com.example.carstore.services;

import com.example.carstore.entities.TestDriveBooking;
import com.example.carstore.repositories.TestDriveBookingRepo;
import jakarta.servlet.http.HttpSession;

import java.util.Date;
import java.util.List;

public interface TestDriveBookingServiceInterface  {

    List<TestDriveBooking> getTestDriveBookings();
    TestDriveBooking createTestDriveBooking(HttpSession session, Date testDriveDate);
}
