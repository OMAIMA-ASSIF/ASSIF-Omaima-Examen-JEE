package net.omaima.backend.services;

import lombok.RequiredArgsConstructor;
import net.omaima.backend.dtos.*;
import net.omaima.backend.entities.*;
import net.omaima.backend.enums.ContratStatus;
import net.omaima.backend.mappers.ContratAssuranceMapperImpl;
import net.omaima.backend.repositories.ClientRepository;
import net.omaima.backend.repositories.ContratAssuranceRepository;
import net.omaima.backend.repositories.PaiementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ContratAssuranceServiceImpl implements ContratAssuranceService {

    private final ClientRepository clientRepository;
    private final ContratAssuranceRepository contratRepository;
    private final PaiementRepository paiementRepository;
    private final ContratAssuranceMapperImpl mapper;

    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = mapper.fromCustomerDTO(clientDTO);
        client = clientRepository.save(client);
        return mapper.fromCustomer(client);
    }

    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        return mapper.fromCustomer(client);
    }

    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> result = new ArrayList<>();
        for (Client c : clients) {
            result.add(mapper.fromCustomer(c));
        }
        return result;
    }

    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        client = clientRepository.save(client);
        return mapper.fromCustomer(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public ContratAssuranceDTO getContrat(Long id) {
        ContratAssurance contrat = contratRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat non trouvé"));
        if (contrat instanceof AutomobileContrat) {
            return mapper.fromAutomobileContrat((AutomobileContrat) contrat);
        } else if (contrat instanceof HabitationContrat) {
            return mapper.fromHabitationContrat((HabitationContrat) contrat);
        } else if (contrat instanceof SanteContrat) {
            return mapper.fromSanteContrat((SanteContrat) contrat);
        } else {
            throw new IllegalStateException("Type de contrat inconnu");
        }
    }

    public List<ContratAssuranceDTO> getAllContrats() {
        return contratRepository.findAll().stream()
                .map(contrat -> {
                    if (contrat instanceof AutomobileContrat) {
                        return mapper.fromAutomobileContrat((AutomobileContrat) contrat);
                    } else if (contrat instanceof HabitationContrat) {
                        return mapper.fromHabitationContrat((HabitationContrat) contrat);
                    } else if (contrat instanceof SanteContrat) {
                        return mapper.fromSanteContrat((SanteContrat) contrat);
                    } else {
                        throw new IllegalStateException("Type de contrat inconnu");
                    }
                })
                .collect(Collectors.toList());
    }

    public void deleteContrat(Long id) {
        contratRepository.deleteById(id);
    }

    public AutomobileContratDTO createAutomobileContrat(AutomobileContratDTO dto) {
        AutomobileContrat contrat = mapper.fromAutomobileDTO(dto);
        if (contrat.getClient() == null || contrat.getClient().getId() == null) {
            throw new RuntimeException("Client requis pour créer un contrat");
        }
        if (contrat.getCreatedAt() == null) contrat.setCreatedAt(new Date());
        if (contrat.getStatus() == null) contrat.setStatus(ContratStatus.Valide);
        contrat = contratRepository.save(contrat);
        return mapper.fromAutomobileContrat(contrat);
    }

    public AutomobileContratDTO updateAutomobileContrat(Long id, AutomobileContratDTO dto) {
        AutomobileContrat contrat = (AutomobileContrat) contratRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat automobile non trouvé"));
        contrat.setImmatriculation(dto.getImmatriculation());
        contrat.setMarque(dto.getMarque());
        contrat.setModele(dto.getModele());
        contrat.setMontantCotisation(dto.getMontantCotisation());
        contrat.setDureeContrat(dto.getDureeContrat());
        contrat.setTauxCouverture(dto.getTauxCouverture());
        contrat.setStatus(dto.getStatus());
        contrat.setDateValidation(dto.getDateValidation());
        if (dto.getClientDTO() != null && dto.getClientDTO().getId() != null) {
            Client client = clientRepository.findById(dto.getClientDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Client non trouvé"));
            contrat.setClient(client);
        }
        contrat = contratRepository.save(contrat);
        return mapper.fromAutomobileContrat(contrat);
    }

    public HabitationContratDTO createHabitationContrat(HabitationContratDTO dto) {
        HabitationContrat contrat = mapper.fromHabitationDTO(dto);
        if (contrat.getCreatedAt() == null) contrat.setCreatedAt(new Date());
        if (contrat.getStatus() == null) contrat.setStatus(ContratStatus.Valide);
        contrat = contratRepository.save(contrat);
        return mapper.fromHabitationContrat(contrat);
    }

    public HabitationContratDTO updateHabitationContrat(Long id, HabitationContratDTO dto) {
        HabitationContrat contrat = (HabitationContrat) contratRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat habitation non trouvé"));
        contrat.setTypeLogement(dto.getTypeLogement());
        contrat.setAdresse(dto.getAdresse());
        contrat.setSuperficie(dto.getSuperficie());
        contrat.setMontantCotisation(dto.getMontantCotisation());
        contrat.setDureeContrat(dto.getDureeContrat());
        contrat.setTauxCouverture(dto.getTauxCouverture());
        contrat.setStatus(dto.getStatus());
        contrat.setDateValidation(dto.getDateValidation());
        if (dto.getClientDTO() != null && dto.getClientDTO().getId() != null) {
            Client client = clientRepository.findById(dto.getClientDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Client non trouvé"));
            contrat.setClient(client);
        }
        contrat = contratRepository.save(contrat);
        return mapper.fromHabitationContrat(contrat);
    }

    public SanteContratDTO createSanteContrat(SanteContratDTO dto) {
        SanteContrat contrat = mapper.fromSanteDTO(dto);
        if (contrat.getCreatedAt() == null) contrat.setCreatedAt(new Date());
        if (contrat.getStatus() == null) contrat.setStatus(ContratStatus.Valide);
        contrat = contratRepository.save(contrat);
        return mapper.fromSanteContrat(contrat);
    }

    public SanteContratDTO updateSanteContrat(Long id, SanteContratDTO dto) {
        SanteContrat contrat = (SanteContrat) contratRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat santé non trouvé"));
        contrat.setNiveauCouverture(dto.getNiveauCouverture());
        contrat.setNombrePersonnesCouvertes(dto.getNombrePersonnesCouvertes());
        contrat.setMontantCotisation(dto.getMontantCotisation());
        contrat.setDureeContrat(dto.getDureeContrat());
        contrat.setTauxCouverture(dto.getTauxCouverture());
        contrat.setStatus(dto.getStatus());
        contrat.setDateValidation(dto.getDateValidation());
        if (dto.getClientDTO() != null && dto.getClientDTO().getId() != null) {
            Client client = clientRepository.findById(dto.getClientDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Client non trouvé"));
            contrat.setClient(client);
        }
        contrat = contratRepository.save(contrat);
        return mapper.fromSanteContrat(contrat);
    }

    public PaiementDTO createPaiement(PaiementDTO paiementDTO) {
        Paiement paiement = mapper.fromPaiementDTO(paiementDTO);
        if (paiement.getCreatedAt() == null) paiement.setCreatedAt(new Date());
        if (paiement.getContratAssurance() != null && paiement.getContratAssurance().getId() != null) {
            ContratAssurance contrat = contratRepository.findById(paiement.getContratAssurance().getId())
                    .orElseThrow(() -> new RuntimeException("Contrat associé non trouvé"));
            paiement.setContratAssurance(contrat);
        } else {
            throw new RuntimeException("Le paiement doit être associé à un contrat existant");
        }
        paiement = paiementRepository.save(paiement);
        return mapper.fromPaiement(paiement);
    }

    public PaiementDTO getPaiement(Long id) {
        Paiement paiement = paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement non trouvé"));
        return mapper.fromPaiement(paiement);
    }

    public List<PaiementDTO> getAllPaiements() {
        return paiementRepository.findAll().stream()
                .map(mapper::fromPaiement)
                .collect(Collectors.toList());
    }

    public List<PaiementDTO> getPaiementsByContrat(Long contratId) {
        Arrays paiements = paiementRepository.findByContratAssuranceId(contratId);
        List<PaiementDTO> result = new ArrayList<>();
        for (Paiement p : paiements) {
            result.add(mapper.fromPaiement(p));
        }
        return result;
    }

    public void deletePaiement(Long id) {
        paiementRepository.deleteById(id);
    }

}