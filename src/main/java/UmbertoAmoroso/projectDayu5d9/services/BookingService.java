package UmbertoAmoroso.projectDayu5d9.services;

import UmbertoAmoroso.projectDayu5d9.entities.Booking;
import UmbertoAmoroso.projectDayu5d9.entities.Dipendente;
import UmbertoAmoroso.projectDayu5d9.entities.Viaggio;
import UmbertoAmoroso.projectDayu5d9.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // Create
    public Booking creaBooking(Booking booking) {
        if (bookingRepository.existsByDipendenteAndDataRichiesta(booking.getDipendente(), booking.getDataRichiesta())) {
            throw new RuntimeException("Prenotazione già esistente per questa data.");
        }
        return bookingRepository.save(booking);
    }

    // Read
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prenotazione non trovata"));
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingsByDipendente(Dipendente dipendente) {
        return bookingRepository.findByDipendente(dipendente);
    }

    public List<Booking> getBookingsByViaggio(Viaggio viaggio) {
        return bookingRepository.findByViaggio(viaggio);
    }

    // Update
    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prenotazione non trovata"));
        booking.setViaggio(updatedBooking.getViaggio());
        booking.setDipendente(updatedBooking.getDipendente());
        booking.setDataRichiesta(updatedBooking.getDataRichiesta());
        booking.setNote(updatedBooking.getNote());
        booking.setPreferenze(updatedBooking.getPreferenze());
        return bookingRepository.save(booking);
    }

    // Delete
    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Prenotazione non trovata");
        }
        bookingRepository.deleteById(id);
    }
}
