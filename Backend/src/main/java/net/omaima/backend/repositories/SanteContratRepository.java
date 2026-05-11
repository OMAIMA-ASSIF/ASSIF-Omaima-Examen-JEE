package net.omaima.backend.repositories;

import net.omaima.backend.entities.SanteContrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SanteContratRepository extends JpaRepository<SanteContrat, Long> {
}
