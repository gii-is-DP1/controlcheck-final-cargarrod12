package org.springframework.samples.petclinic.care;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class CareProvision extends BaseEntity{

    @Min(0)
    @NotNull
    double duration;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne
    Visit visit;

    @NotNull
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    Care care;   
}
