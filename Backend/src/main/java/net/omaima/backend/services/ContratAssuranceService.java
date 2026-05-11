package net.omaima.backend.services;

import net.omaima.backend.dtos.*;
import java.util.List;

public interface ContratAssuranceService {


    ClientDTO createClient(ClientDTO clientDTO);
    ClientDTO getClient(Long id);
    List<ClientDTO> getAllClients();
    ClientDTO updateClient(Long id, ClientDTO clientDTO);
    void deleteClient(Long id);
    ContratAssuranceDTO getContrat(Long id);
    List<ContratAssuranceDTO> getAllContrats();
    void deleteContrat(Long id);
    AutomobileContratDTO createAutomobileContrat(AutomobileContratDTO dto);
    AutomobileContratDTO updateAutomobileContrat(Long id, AutomobileContratDTO dto);
    HabitationContratDTO createHabitationContrat(HabitationContratDTO dto);
    HabitationContratDTO updateHabitationContrat(Long id, HabitationContratDTO dto);
    SanteContratDTO createSanteContrat(SanteContratDTO dto);
    SanteContratDTO updateSanteContrat(Long id, SanteContratDTO dto);
    PaiementDTO createPaiement(PaiementDTO paiementDTO);
    PaiementDTO getPaiement(Long id);
    List<PaiementDTO> getAllPaiements();
    List<PaiementDTO> getPaiementsByContrat(Long contratId);
    void deletePaiement(Long id);
}