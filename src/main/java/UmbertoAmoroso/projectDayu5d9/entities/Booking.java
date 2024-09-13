package UmbertoAmoroso.projectDayu5d9.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Viaggio viaggio;

    @ManyToOne
    private Dipendente dipendente;

    private LocalDate dataRichiesta;

    private String note;

    private String preferenze;
}
