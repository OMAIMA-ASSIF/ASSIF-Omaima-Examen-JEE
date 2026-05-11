package net.omaima.backend.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import net.omaima.backend.entities.ContratAssurance;
import net.omaima.backend.enums.TypePaiement;

import java.util.Date;

@Data
public class PaiementDTO {
    private Long id;
    private Date createdAt;
    private double montant;
    private TypePaiement typePaiement;
    private ContratAssurance contratAssurance;
}
