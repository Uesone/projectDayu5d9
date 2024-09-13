package UmbertoAmoroso.projectDayu5d9.controllers;

import UmbertoAmoroso.projectDayu5d9.entities.Viaggio;
import UmbertoAmoroso.projectDayu5d9.enums.StatoViaggio;
import UmbertoAmoroso.projectDayu5d9.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio creaViaggio(@RequestBody Viaggio viaggio) {
        return viaggioService.createViaggio(viaggio);
    }

    @GetMapping("/{id}")
    public Viaggio getViaggioById(@PathVariable Long id) {
        return viaggioService.getViaggioById(id);
    }

    @GetMapping
    public List<Viaggio> getAllViaggi() {
        return viaggioService.getAllViaggi();
    }

    @PutMapping("/{id}")
    public Viaggio updateViaggio(@PathVariable Long id, @RequestBody Viaggio updatedViaggio) {
        return viaggioService.updateViaggio(id, updatedViaggio);
    }

    @PutMapping("/{id}/stato")
    public Viaggio modificaStatoViaggio(@PathVariable Long id, @RequestParam StatoViaggio stato) {
        return viaggioService.updateStato(id, stato);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteViaggio(@PathVariable Long id) {
        viaggioService.deleteViaggio(id);
    }
}
