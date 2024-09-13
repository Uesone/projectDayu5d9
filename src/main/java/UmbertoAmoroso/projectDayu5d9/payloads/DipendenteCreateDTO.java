package UmbertoAmoroso.projectDayu5d9.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString

public class DipendenteCreateDTO {
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String immagineProfiloUrl;

    public DipendenteCreateDTO(String username, String nome, String cognome, String email, String immagineProfiloUrl) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.immagineProfiloUrl = immagineProfiloUrl;
    }

}