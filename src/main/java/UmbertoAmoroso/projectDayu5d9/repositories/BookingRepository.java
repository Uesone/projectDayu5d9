package UmbertoAmoroso.projectDayu5d9.repositories;

import UmbertoAmoroso.projectDayu5d9.entities.Booking;
import UmbertoAmoroso.projectDayu5d9.entities.Dipendente;
import UmbertoAmoroso.projectDayu5d9.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    boolean existsByDipendenteAndDataRichiesta(Dipendente dipendente, LocalDate dataRichiesta);

    List<Booking> findByDipendente(Dipendente dipendente);

    List<Booking> findByViaggio(Viaggio viaggio);
}
