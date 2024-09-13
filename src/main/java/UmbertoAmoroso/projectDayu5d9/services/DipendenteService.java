package UmbertoAmoroso.projectDayu5d9.services;

import UmbertoAmoroso.projectDayu5d9.entities.Dipendente;
import UmbertoAmoroso.projectDayu5d9.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendenteService {

    private final DipendenteRepository dipendenteRepository;

    @Autowired
    public DipendenteService(DipendenteRepository dipendenteRepository) {
        this.dipendenteRepository = dipendenteRepository;
    }

    public Dipendente creaDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public Dipendente getDipendenteById(Long id) {
        return dipendenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));
    }

    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    public Dipendente updateDipendente(Long id, Dipendente updatedDipendente) {
        Dipendente dipendente = dipendenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));
        dipendente.setUsername(updatedDipendente.getUsername());
        dipendente.setNome(updatedDipendente.getNome());
        dipendente.setCognome(updatedDipendente.getCognome());
        dipendente.setEmail(updatedDipendente.getEmail());
        dipendente.setImmagineProfilo(updatedDipendente.getImmagineProfilo());
        return dipendenteRepository.save(dipendente);
    }

    public void deleteDipendente(Long id) {
        if (!dipendenteRepository.existsById(id)) {
            throw new RuntimeException("Dipendente non trovato");
        }
        dipendenteRepository.deleteById(id);
    }
}
