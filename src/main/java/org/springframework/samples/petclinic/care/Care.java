package org.springframework.samples.petclinic.care;

import java.util.Set;

import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Care {
    String name;
    String description;
    Set<PetType> compatiblePetTypes;
}
