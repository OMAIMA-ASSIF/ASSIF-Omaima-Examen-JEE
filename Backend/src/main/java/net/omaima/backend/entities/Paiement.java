package net.omaima.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.omaima.backend.enums.TypePaiement;

import java.util.Date;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Paiement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private double montant;
    private TypePaiement typePaiement;
    @ManyToOne
    private ContratAssurance contratAssurance;

}
