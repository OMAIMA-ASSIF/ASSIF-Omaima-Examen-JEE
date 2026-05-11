package net.omaima.backend.dtos;

import lombok.Data;
import net.omaima.backend.entities.Client;
import net.omaima.backend.entities.ContratAssurance;
import net.omaima.backend.enums.ContratStatus;
import net.omaima.backend.enums.TypeLogement;

import java.util.Date;

@Data
public class HabitationContratDTO extends ContratAssuranceDTO {
    private Long id;
    private Date createdAt;
    private ContratStatus status;
    private Date dateValidation;
    private double montantCotisation;
    private double DureeContrat;
    private double tauxCouverture;
    private ClientDTO clientDTO;
    private TypeLogement typeLogement;
    private String adresse;
    private double superficie;

}
