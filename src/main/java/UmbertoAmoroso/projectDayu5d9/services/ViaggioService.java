package UmbertoAmoroso.projectDayu5d9.services;

import UmbertoAmoroso.projectDayu5d9.entities.Viaggio;
import UmbertoAmoroso.projectDayu5d9.enums.StatoViaggio;
import UmbertoAmoroso.projectDayu5d9.repositories.ViaggioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaggioService {

    private final ViaggioRepository viaggioRepository;

    public ViaggioService(ViaggioRepository viaggioRepository) {
        this.viaggioRepository = viaggioRepository;
    }

    public Viaggio createViaggio(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    public Viaggio getViaggioById(Long id) {
        return viaggioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viaggio non trovato"));
    }

    public List<Viaggio> getAllViaggi() {
        return viaggioRepository.findAll();
    }

    public Viaggio updateStato(Long id, StatoViaggio stato) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viaggio non trovato"));
        viaggio.setStato(stato);
        return viaggioRepository.save(viaggio);
    }

    public Viaggio updateViaggio(Long id, Viaggio updatedViaggio) {
        Viaggio viaggio = viaggioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viaggio non trovato"));
        viaggio.setDestinazione(updatedViaggio.getDestinazione());
        viaggio.setData(updatedViaggio.getData());
        viaggio.setStato(updatedViaggio.getStato());
        return viaggioRepository.save(viaggio);
    }

    public void deleteViaggio(Long id) {
        if (!viaggioRepository.existsById(id)) {
            throw new RuntimeException("Viaggio non trovato");
        }
        viaggioRepository.deleteById(id);
    }
}
