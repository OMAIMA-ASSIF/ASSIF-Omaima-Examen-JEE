package net.omaima.backend.mappers;


import net.omaima.backend.dtos.*;
import net.omaima.backend.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ContratAssuranceMapperImpl {
    public ClientDTO fromCustomer(Client client){
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

    public Client fromCustomerDTO(ClientDTO customerDTO){
        Client client = new Client();
        BeanUtils.copyProperties(customerDTO, client);
        return client;
    }

    public HabitationContratDTO fromHabitationContrat(HabitationContrat habitationContrat){
        HabitationContratDTO habitationContratDTO = new HabitationContratDTO();
        BeanUtils.copyProperties(habitationContrat, habitationContratDTO);
        habitationContratDTO.setTypeLogement(habitationContrat.getTypeLogement());
        habitationContratDTO.setAdresse(habitationContrat.getAdresse());
        habitationContratDTO.setSuperficie(habitationContrat.getSuperficie());
        habitationContratDTO.setType(habitationContrat.getClass().getSimpleName());
        return habitationContratDTO;
    }
    public HabitationContrat fromHabitationDTO(HabitationContratDTO habitationDTO){
        HabitationContrat habitationContrat = new HabitationContrat();
        BeanUtils.copyProperties(habitationDTO, habitationContrat);
        habitationContrat.setTypeLogement(habitationDTO.getTypeLogement());
        habitationContrat.setAdresse(habitationDTO.getAdresse());
        habitationContrat.setSuperficie(habitationDTO.getSuperficie());
        return habitationContrat;
    }

    public AutomobileContratDTO fromAutomobileContrat(AutomobileContrat automobileContrat){
        AutomobileContratDTO automobileContratDTO = new AutomobileContratDTO();
        BeanUtils.copyProperties(automobileContrat, automobileContratDTO );
        automobileContratDTO .setImmatriculation(automobileContrat.getImmatriculation());
        automobileContratDTO .setMarque(automobileContrat.getMarque());
        automobileContratDTO .setModele(automobileContrat.getModele());
        automobileContratDTO .setType(automobileContrat.getClass().getSimpleName());
        return automobileContratDTO;
    }

    public AutomobileContrat fromAutomobileDTO(AutomobileContratDTO automobileDTO){
        AutomobileContrat automobileContrat = new AutomobileContrat();
        BeanUtils.copyProperties(automobileDTO, automobileContrat);
        automobileContrat.setImmatriculation(automobileDTO.getImmatriculation());
        automobileContrat.setMarque(automobileDTO.getMarque());
        automobileContrat.setModele(automobileDTO.getModele());
        return automobileContrat;
    }

    public SanteContratDTO fromSanteContrat(SanteContrat santeContrat){
        SanteContratDTO santeContratDTO = new SanteContratDTO();
        BeanUtils.copyProperties(santeContrat, santeContratDTO);
        santeContratDTO.setNiveauCouverture(santeContrat.getNiveauCouverture());
        santeContratDTO.setNombrePersonnesCouvertes(santeContrat.getNombrePersonnesCouvertes());
        santeContratDTO.setType("Sante");
        return santeContratDTO;
    }

    public SanteContrat fromSanteDTO(SanteContratDTO santeDTO){
        SanteContrat santeContrat = new SanteContrat();
        BeanUtils.copyProperties(santeDTO, santeContrat);
        santeContrat.setNiveauCouverture(santeDTO.getNiveauCouverture());
        santeContrat.setNombrePersonnesCouvertes(santeDTO.getNombrePersonnesCouvertes());
        return santeContrat;
    }

    public PaiementDTO fromPaiement(Paiement paiement){
        PaiementDTO paiementDTO = new PaiementDTO();
        BeanUtils.copyProperties(paiement, paiementDTO);
        paiementDTO.setContratAssurance(paiement.getContratAssurance());
        return paiementDTO;

    }
    public Paiement fromPaiementDTO(PaiementDTO paiementDTO){
        Paiement paiement = new Paiement();
        BeanUtils.copyProperties(paiementDTO, paiement);
        paiementDTO.setContratAssurance(paiement.getContratAssurance());
        return paiement;
    }


}
