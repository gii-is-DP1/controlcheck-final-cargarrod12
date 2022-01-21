package org.springframework.samples.petclinic.care;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CareService {

    @Autowired
    CareProvisionRepository careProvisionRepository;


    public List<Care> getAllCares(){
        return careProvisionRepository.findAllCares();
    }

    public List<Care> getAllCompatibleCares(String petTypeName){
       return careProvisionRepository.findCompatibleCares(petTypeName);
    }

    public Care getCare(String careName) {
        return careProvisionRepository.findCareByName(careName);
    }


    public CareProvision save(CareProvision p) throws NonCompatibleCaresException, UnfeasibleCareException {
        return careProvisionRepository.save(p);
    }

    public List<CareProvision> getAllCaresProvided(){
        return careProvisionRepository.findAll();
    }

    public List<CareProvision> getCaresProvided(Integer visitId){
        return null;

    }

}
