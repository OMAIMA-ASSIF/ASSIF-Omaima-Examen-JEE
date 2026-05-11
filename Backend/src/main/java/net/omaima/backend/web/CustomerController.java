package net.omaima.backend.web;

import lombok.RequiredArgsConstructor;
import net.omaima.backend.dtos.ClientDTO;
import net.omaima.backend.services.ContratAssuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final ContratAssuranceService service;

    @PostMapping("/clients")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        ClientDTO created = service.createClient(clientDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) {
        ClientDTO client = service.getClient(id);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> clients = service.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        ClientDTO updated = service.updateClient(id, clientDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        service.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}