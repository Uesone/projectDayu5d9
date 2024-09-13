package UmbertoAmoroso.projectDayu5d9.payloads;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingDTO {
    private Long id;
    private Long viaggioId; // Id del viaggio associato
    private Long dipendenteId; // Id del dipendente associato
    private LocalDate dataRichiesta;
    private String note;
    private String preferenze;
}
