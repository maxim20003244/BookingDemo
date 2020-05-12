package bookingdemo.demo.controller;
import java.util.*;
import java.util.stream.Collectors;

import bookingdemo.demo.BookingRepository;
import bookingdemo.demo.model.HotelBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    BookingRepository bookingRepository;
    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public BookingController(){

    }
    @RequestMapping(value = "/all" , method = RequestMethod.GET)
    public List<HotelBooking> geAll() {
      return bookingRepository.findAll();
    }
   @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price) {
    return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking) {
       bookingRepository.save(hotelBooking);
       return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public List<HotelBooking> remove(@PathVariable long id){
       bookingRepository.deleteById(id);
       return bookingRepository.findAll();

    }
}
