package UmbertoAmoroso.projectDayu5d9.entities;
import UmbertoAmoroso.projectDayu5d9.enums.StatoViaggio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinazione;

    private LocalDate data;


    public void setStato(StatoViaggio statoViaggio) {

    }
}
