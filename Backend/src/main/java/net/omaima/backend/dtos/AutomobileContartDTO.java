package net.omaima.backend.dtos;

import lombok.Data;
import net.omaima.backend.enums.ContratStatus;

import java.util.Date;

@Data
public class AutomobileContartDTO extends ContratAssuranceDTO {
    private Long id;
    private Date createdAt;
    private ContratStatus status;
    private Date dateValidation;
    private double montantCotisation;
    private double DureeContrat;
    private double tauxCouverture;
    private ClientDTO clientDTO;
    private String immatriculation;
    private String marque;
    private String modele;
}
