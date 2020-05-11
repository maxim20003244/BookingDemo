package bookingdemo.demo;

import bookingdemo.demo.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<HotelBooking, Long> {

    List<HotelBooking> findByPricePerNightLessThan(double price);



}
