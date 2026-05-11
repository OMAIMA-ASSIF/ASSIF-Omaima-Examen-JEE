package net.omaima.backend;

import net.omaima.backend.dtos.ContratAssuranceDTO;
import net.omaima.backend.entities.AutomobileContrat;
import net.omaima.backend.entities.Client;
import net.omaima.backend.entities.Paiement;
import net.omaima.backend.entities.SanteContrat;
import net.omaima.backend.repositories.ClientRepository;
import net.omaima.backend.repositories.ContratAssuranceRepository;
import net.omaima.backend.repositories.PaiementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean//test DAO
	CommandLineRunner commandLineRunner(ClientRepository clientRepository, ContratAssuranceRepository contratAssuranceRepository, PaiementRepository paiementRepository) {
		return args -> {
			Stream.of("Omaima", "Soumia", "Hasna").forEach(name -> {
				Client client = new Client();
				client.setName(name);
				client.setEmail(name + "@gmail.com");
				clientRepository.save(client);
			});
			clientRepository.findAll().forEach(client -> {
				AutomobileContrat auto = new AutomobileContrat();
				auto.setCreatedAt(new Date());
				auto.setClient(client);
				auto.setMarque("Marque1");
				auto.setModele("Modele1");
				auto.setImmatriculation("123-238-Ai");
				contratAssuranceRepository.save(auto);

				SanteContrat sante = new SanteContrat();
				sante.setCreatedAt(new Date());
				sante.setMontantCotisation(800.0);
				sante.setClient(client);
				sante.setNombrePersonnesCouvertes(2);
				contratAssuranceRepository.save(sante);

				Paiement p = new Paiement();
				p.setMontant(200.0);
				p.setCreatedAt(new Date());
				p.setContratAssurance(auto);
				paiementRepository.save(p);
			});
		};


	}


}
