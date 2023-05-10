package com.example.carstore.repositories;

import com.example.carstore.entities.TestDriveBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDriveBookingRepo extends JpaRepository<TestDriveBooking,Long> {
}
