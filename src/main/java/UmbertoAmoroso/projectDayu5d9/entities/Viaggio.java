package UmbertoAmoroso.projectDayu5d9.entities;

import UmbertoAmoroso.projectDayu5d9.enums.StatoViaggio;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinazione;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatoViaggio stato;
}
