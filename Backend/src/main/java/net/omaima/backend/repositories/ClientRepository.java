package net.omaima.backend.repositories;

import net.omaima.backend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client, Long > {
}
