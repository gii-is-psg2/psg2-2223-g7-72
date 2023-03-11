package org.springframework.samples.petclinic.pethotel;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class PetHotelOwnerDetailsController {

    private OwnerService ownerService;

    @Autowired
    public PetHotelOwnerDetailsController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder("petHotel")
    public void initPetHotelBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new PetHotelValidator());
    }

    @GetMapping("/petHotels/myProfile")
    public String myProfile(Principal principal) {
        Owner owner = ownerService.findOwnerByUsername(principal.getName());

        return "redirect:/owners/" + owner.getId();
    }
}
