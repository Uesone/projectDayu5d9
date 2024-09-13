package UmbertoAmoroso.projectDayu5d9.controllers;

import UmbertoAmoroso.projectDayu5d9.entities.Booking;
import UmbertoAmoroso.projectDayu5d9.entities.Dipendente;
import UmbertoAmoroso.projectDayu5d9.entities.Viaggio;
import UmbertoAmoroso.projectDayu5d9.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Booking creaBooking(@RequestBody Booking booking) {
        return bookingService.creaBooking(booking);
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/dipendente/{id}")
    public List<Booking> getBookingsByDipendente(@PathVariable Long id) {
        Dipendente dipendente = new Dipendente();
        dipendente.setId(id);
        return bookingService.getBookingsByDipendente(dipendente);
    }

    @GetMapping("/viaggio/{id}")
    public List<Booking> getBookingsByViaggio(@PathVariable Long id) {
        Viaggio viaggio = new Viaggio();
        viaggio.setId(id);
        return bookingService.getBookingsByViaggio(viaggio);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking updatedBooking) {
        return bookingService.updateBooking(id, updatedBooking);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }
}
