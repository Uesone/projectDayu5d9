package UmbertoAmoroso.projectDayu5d9.services;

import UmbertoAmoroso.projectDayu5d9.entities.Booking;
import UmbertoAmoroso.projectDayu5d9.repositories.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

        public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking creaBooking(Booking booking) {
        // Logica per evitare doppie prenotazioni nella stessa data
        if (bookingRepository.existsByDipendenteAndDataRichiesta(booking.getDipendente(), booking.getDataRichiesta())) {
            throw new RuntimeException("Prenotazione già esistente per questa data.");
        }
        return bookingRepository.save(booking);
    }
}