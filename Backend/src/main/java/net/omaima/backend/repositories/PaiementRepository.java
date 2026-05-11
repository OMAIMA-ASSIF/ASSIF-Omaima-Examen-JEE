package net.omaima.backend.repositories;

import net.omaima.backend.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface PaiementRepository  extends JpaRepository<Paiement, Long> {
    List<Paiement> findByContratAssuranceId(Long contratId);
}
