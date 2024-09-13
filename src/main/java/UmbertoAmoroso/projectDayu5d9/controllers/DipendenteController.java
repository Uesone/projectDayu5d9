package UmbertoAmoroso.projectDayu5d9.controllers;

import UmbertoAmoroso.projectDayu5d9.entities.Dipendente;
import UmbertoAmoroso.projectDayu5d9.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    private final DipendenteService dipendenteService;

    @Autowired
    public DipendenteController(DipendenteService dipendenteService) {
        this.dipendenteService = dipendenteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente creaDipendente(@RequestBody Dipendente dipendente) {
        return dipendenteService.creaDipendente(dipendente);
    }

    @GetMapping("/{id}")
    public Dipendente getDipendenteById(@PathVariable Long id) {
        return dipendenteService.getDipendenteById(id);
    }

    @GetMapping
    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.getAllDipendenti();
    }

    @PutMapping("/{id}")
    public Dipendente updateDipendente(@PathVariable Long id, @RequestBody Dipendente updatedDipendente) {
        return dipendenteService.updateDipendente(id, updatedDipendente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDipendente(@PathVariable Long id) {
        dipendenteService.deleteDipendente(id);
    }
}
