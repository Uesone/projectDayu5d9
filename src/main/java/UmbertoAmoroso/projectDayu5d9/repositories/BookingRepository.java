package UmbertoAmoroso.projectDayu5d9.repositories;

import UmbertoAmoroso.projectDayu5d9.entities.Booking;
import UmbertoAmoroso.projectDayu5d9.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsByDipendenteAndDataRichiesta(Dipendente dipendente, LocalDate dataRichiesta);
}
