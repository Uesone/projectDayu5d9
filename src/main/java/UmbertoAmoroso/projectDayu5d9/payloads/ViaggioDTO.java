package UmbertoAmoroso.projectDayu5d9.payloads;


import lombok.*;
import java.time.LocalDate;
import UmbertoAmoroso.projectDayu5d9.enums.StatoViaggio;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ViaggioDTO {
    private Long id;
    private String destinazione;
    private LocalDate data;
    private StatoViaggio statoViaggio;
}
