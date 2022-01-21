package org.springframework.samples.petclinic.care;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.samples.petclinic.pet.Visit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CareController {
    @Autowired
    private CareService cService;
    @Autowired
    private PetService petService;


    @GetMapping("/visit/{visitId}/care/create")
    public String getCreateCare(ModelMap mp, @PathVariable("visitId") Integer visitId){
        CareProvision cp = new CareProvision();
        Visit v = petService.findVisitById(visitId);
        List<Care> compatible = cService.getAllCompatibleCares(v.getPet().getType().getName());
        mp.put("providedCare", cp);
        mp.put("cares", compatible);
        return "care/createOrUpdateProvidedCareForm";
    }

    @PostMapping("/visit/{visitId}/care/create")
    public String postCreateRoom(@Valid CareProvision rr, BindingResult result, ModelMap mp) throws UnfeasibleCareException, NonCompatibleCaresException {
        if (result.hasErrors()){
            mp.put("recoveryRoom",rr);
            return "care/createOrUpdateProvidedCareForm";
        }
        try {
            cService.save(rr);
        }catch (Exception x){
            return "care/createOrUpdateProvidedCareForm";
        }

        return "redirect:/";
    }
    
}
