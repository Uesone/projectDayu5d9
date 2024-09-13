package UmbertoAmoroso.projectDayu5d9.services;

import UmbertoAmoroso.projectDayu5d9.entities.Viaggio;
import UmbertoAmoroso.projectDayu5d9.enums.StatoViaggio;
import UmbertoAmoroso.projectDayu5d9.repositories.ViaggioRepository;

public class ViaggioService {
    private ViaggioRepository viaggioRepository;
    public ViaggioService(ViaggioRepository viaggioRepository){
        this.viaggioRepository = viaggioRepository;
    }

    public Viaggio creaViaggio(Viaggio viaggio){
        viaggio.setStato(StatoViaggio.IN_PROGRAMMA);
    return viaggioRepository.save(viaggio);}
public Viaggio modificaStatoViaggio(Long id, StatoViaggio stato) {
    Viaggio viaggio = viaggioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Viaggio non presente"));
    viaggio.setStato(stato);
    return viaggioRepository.save(viaggio);}
}
