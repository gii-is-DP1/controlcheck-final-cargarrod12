package org.springframework.samples.petclinic.care;

import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CareProvision {   
    double duration;
    Visit visit;
    Care care;   
}
