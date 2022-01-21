package org.springframework.samples.petclinic.care;

import java.util.Set;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Care extends BaseEntity {

    @Size(min = 5, max = 50)
    @Column(unique = true)
    @NotEmpty
    String name;

    @NotEmpty
    String description;

    @NotEmpty
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "compatible", joinColumns = @JoinColumn(name = "care_id"),
            inverseJoinColumns = @JoinColumn(name = "pet_type_id"))
    Set<PetType> compatiblePetTypes;

    @JoinTable(name = "incompatible", joinColumns = @JoinColumn(name = "care_id"),
            inverseJoinColumns = @JoinColumn(name = "care2_id"))
    @ManyToMany(cascade = CascadeType.ALL)
    Set<Care> incompatibleCares;
}
