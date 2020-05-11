package bookingdemo.demo;

import bookingdemo.demo.model.HotelBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DatabasesSeeder implements CommandLineRunner {
   private BookingRepository bookingRepository;

   @Autowired
   public DatabasesSeeder(BookingRepository bookingRepository){
       this.bookingRepository = bookingRepository;
   }

    @Override
    public void run(String... args) throws Exception {
        List<HotelBooking> bookings = new ArrayList<>();
        bookings.add(new HotelBooking("Marriot", 200.76, 4));
        bookings.add(new HotelBooking("Ibis", 94.99,9 ));
        bookings.add(new HotelBooking("Public", 25,7 ));

        bookingRepository.saveAll(bookings);
    }
}
