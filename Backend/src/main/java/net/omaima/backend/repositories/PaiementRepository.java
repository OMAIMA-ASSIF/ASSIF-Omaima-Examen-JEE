package net.omaima.backend.repositories;

import net.omaima.backend.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;

public interface PaiementRepository  extends JpaRepository<Paiement, Long> {
    Arrays findByContratAssuranceId(Long contratId);
}
