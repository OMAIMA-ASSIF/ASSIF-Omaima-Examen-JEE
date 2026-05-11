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
    private Date createdAt;
    private double montant;
    @Enumerated(EnumType.STRING)
    private TypePaiement typePaiement;
    @ManyToOne
    private ContratAssurance contratAssurance;

}
