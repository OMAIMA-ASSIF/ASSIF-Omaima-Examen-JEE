package net.omaima.backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.omaima.backend.enums.TypeLogement;

@Entity
@DiscriminatorValue("Habitation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HabitationContrat extends ContratAssurance{
    private TypeLogement typeLogement;
    private String adresse;
    private double superficie;
}
