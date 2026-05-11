package net.omaima.backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Automobile")
public class AutomobileContrat extends ContratAssurance{
    private String immatriculation;
    private String marque;
    private String modele;
}
