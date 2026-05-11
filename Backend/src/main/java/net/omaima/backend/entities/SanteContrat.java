package net.omaima.backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.omaima.backend.enums.NiveauCouverture;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Sante")
public class SanteContrat extends ContratAssurance{
    @Enumerated(EnumType.STRING)
    private NiveauCouverture niveauCouverture;
    private int nombrePersonnesCouvertes;

}
