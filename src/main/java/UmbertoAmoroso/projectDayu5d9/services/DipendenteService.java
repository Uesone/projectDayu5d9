package UmbertoAmoroso.projectDayu5d9.services;

import UmbertoAmoroso.projectDayu5d9.entities.Dipendente;
import UmbertoAmoroso.projectDayu5d9.repositories.DipendenteRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class DipendenteService {

    private final Cloudinary cloudinary;
    private final DipendenteRepository dipendenteRepository;

    @Autowired
    public DipendenteService(Cloudinary cloudinary, DipendenteRepository dipendenteRepository) {
        this.cloudinary = cloudinary;
        this.dipendenteRepository = dipendenteRepository;
    }

    // Metodo per creare un dipendente
    public Dipendente creaDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    // Metodo per ottenere un dipendente per ID
    public Dipendente getDipendenteById(Long id) {
        return dipendenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Dipendente non trovato"));
    }

    // Metodo per ottenere tutti i dipendenti
    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    // Metodo per aggiornare un dipendente
    public Dipendente updateDipendente(Long id, Dipendente updatedDipendente) {
        Dipendente dipendente = getDipendenteById(id);
        dipendente.setUsername(updatedDipendente.getUsername());
        dipendente.setNome(updatedDipendente.getNome());
        dipendente.setCognome(updatedDipendente.getCognome());
        dipendente.setEmail(updatedDipendente.getEmail());
        dipendente.setImmagineProfilo(updatedDipendente.getImmagineProfilo());
        return dipendenteRepository.save(dipendente);
    }

    // Metodo per cancellare un dipendente
    public void deleteDipendente(Long id) {
        dipendenteRepository.deleteById(id);
    }

    // Metodo per l'upload dell'immagine avatar
    public Dipendente uploadImage(Long employeeId, MultipartFile image) throws IOException {
        Dipendente dipendente = getDipendenteById(employeeId);

        Map uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
        String imageUrl = uploadResult.get("url").toString();

        dipendente.setImmagineProfilo(imageUrl);
        return dipendenteRepository.save(dipendente);
    }
}
