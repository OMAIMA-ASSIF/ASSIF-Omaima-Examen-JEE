package net.omaima.backend.web;

import lombok.RequiredArgsConstructor;
import net.omaima.backend.dtos.*;
import net.omaima.backend.services.ContratAssuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContratAssuranceController {

    private final ContratAssuranceService service;

    @GetMapping("/contrats/{id}")
    public ResponseEntity<ContratAssuranceDTO> getContrat(@PathVariable Long id) {
        ContratAssuranceDTO contrat = service.getContrat(id);
        return ResponseEntity.ok(contrat);
    }

    @GetMapping("/contrats")
    public ResponseEntity<List<ContratAssuranceDTO>> getAllContrats() {
        List<ContratAssuranceDTO> contrats = service.getAllContrats();
        return ResponseEntity.ok(contrats);
    }

    @DeleteMapping("/contrats/{id}")
    public ResponseEntity<Void> deleteContrat(@PathVariable Long id) {
        service.deleteContrat(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/contrats/automobile")
    public ResponseEntity<AutomobileContratDTO> createAutomobileContrat(@RequestBody AutomobileContratDTO dto) {
        AutomobileContratDTO created = service.createAutomobileContrat(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/contrats/automobile/{id}")
    public ResponseEntity<AutomobileContratDTO> updateAutomobileContrat(@PathVariable Long id,
                                                                        @RequestBody AutomobileContratDTO dto) {
        AutomobileContratDTO updated = service.updateAutomobileContrat(id, dto);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/contrats/habitation")
    public ResponseEntity<HabitationContratDTO> createHabitationContrat(@RequestBody HabitationContratDTO dto) {
        HabitationContratDTO created = service.createHabitationContrat(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/contrats/habitation/{id}")
    public ResponseEntity<HabitationContratDTO> updateHabitationContrat(@PathVariable Long id,
                                                                        @RequestBody HabitationContratDTO dto) {
        HabitationContratDTO updated = service.updateHabitationContrat(id, dto);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/contrats/sante")
    public ResponseEntity<SanteContratDTO> createSanteContrat(@RequestBody SanteContratDTO dto) {
        SanteContratDTO created = service.createSanteContrat(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/contrats/sante/{id}")
    public ResponseEntity<SanteContratDTO> updateSanteContrat(@PathVariable Long id,
                                                              @RequestBody SanteContratDTO dto) {
        SanteContratDTO updated = service.updateSanteContrat(id, dto);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/contrats/paiements")
    public ResponseEntity<PaiementDTO> createPaiement(@RequestBody PaiementDTO dto) {
        PaiementDTO created = service.createPaiement(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/contrats/paiements/{id}")
    public ResponseEntity<PaiementDTO> getPaiement(@PathVariable Long id) {
        PaiementDTO paiement = service.getPaiement(id);
        return ResponseEntity.ok(paiement);
    }

    @GetMapping("/contrats/paiements")
    public ResponseEntity<List<PaiementDTO>> getAllPaiements() {
        List<PaiementDTO> paiements = service.getAllPaiements();
        return ResponseEntity.ok(paiements);
    }

    @GetMapping("/contrats/paiements/contrat/{contratId}")
    public ResponseEntity<List<PaiementDTO>> getPaiementsByContrat(@PathVariable Long contratId) {
        List<PaiementDTO> paiements = service.getPaiementsByContrat(contratId);
        return ResponseEntity.ok(paiements);
    }

    @DeleteMapping("/contrats/paiements/{id}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long id) {
        service.deletePaiement(id);
        return ResponseEntity.noContent().build();
    }
}