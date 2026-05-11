package net.omaima.backend.dtos;

import lombok.Data;
import net.omaima.backend.enums.ContratStatus;
import net.omaima.backend.enums.NiveauCouverture;

import java.util.Date;

@Data
public class SanteContratDTO extends ContratAssuranceDTO {
    private Long id;
    private Date createdAt;
    private ContratStatus status;
    private Date dateValidation;
    private double montantCotisation;
    private double DureeContrat;
    private double tauxCouverture;
    private ClientDTO clientDTO;
    private NiveauCouverture niveauCouverture;
    private int nombrePersonnesCouvertes;
}
