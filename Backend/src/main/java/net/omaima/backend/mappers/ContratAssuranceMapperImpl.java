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

    }
    public HabitationContrat fromHabitationDTO(HabitationContratDTO habitationDTO){

    }

    public AutomobileContratDTO fromAutomobileContrat(AutomobileContrat automobileContrat){

    }

    public AutomobileContrat fromAutomobileDTO(AutomobileContratDTO automobileDTO){

    }

    public SanteContratDTO fromSanteContrat(SanteContrat santeContrat){

    }

    public SanteContrat fromSanteDTO(SanteContratDTO santeDTO){

    }

    public PaiementDTO fromPaiement(PaiementDTO paiementDTO){

    }
    public Paiement fromPaiementDTO(PaiementDTO paiementDTO){

    }


}
