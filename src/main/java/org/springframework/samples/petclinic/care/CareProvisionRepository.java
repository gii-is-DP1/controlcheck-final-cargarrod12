package org.springframework.samples.petclinic.care;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CareProvisionRepository extends CrudRepository<CareProvision, Integer> {
    List<CareProvision> findAll();
    Optional<CareProvision> findById(int id);


    CareProvision save(CareProvision p);

    @Query("Select distinct c From Care c")
    List<Care> findAllCares();

    @Query("select care from Care care join care.compatiblePetTypes type where type.name = ?1 ")
    List<Care> findCompatibleCares(String petTypeName);

    @Query("SELECT c from Care c where c.name = ?1")
    Care findCareByName(String name);
    //List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
}
