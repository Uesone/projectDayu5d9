package UmbertoAmoroso.projectDayu5d9.payloads;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString


public class DipendenteDTO {
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String immagineProfiloUrl;


    public DipendenteDTO(Long id, String username, String nome, String cognome, String email, String immagineProfiloUrl) {
        this.id = id;
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.immagineProfiloUrl = immagineProfiloUrl;
    }

}
