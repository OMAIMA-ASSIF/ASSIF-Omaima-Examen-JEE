package net.omaima.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.omaima.backend.enums.ContratStatus;

import java.util.Date;
import java.util.List;


@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",length = 4)
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public abstract class ContratAssurance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private ContratStatus status;
    private Date dateValidation;
    private double montantCotisation;
    private double DureeContrat;
    private double tauxCouverture;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "ContratAssurance" , fetch = FetchType.LAZY)
    private List<Paiement> paiementList;
}
