package org.springframework.samples.petclinic.pethotel;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PetHotelController {

    private final String PET_HOTEL_FORM = "petHotels/createOrUpdatePetHotelForm";

    private final PetHotelService petHotelService;
    private final OwnerService ownerService;
    private final PetService petService;

    @Autowired
    public PetHotelController(PetHotelService petHotelService, OwnerService ownerService, PetService petService) {
        this.petHotelService = petHotelService;
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") int ownerId) {
        return this.ownerService.findOwnerById(ownerId);
    }

    @ModelAttribute("pet")
    public Pet findPet(@PathVariable("petId") int petId) {
        return this.petService.findPetById(petId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @InitBinder("pet")
    public void initPetBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @InitBinder("petHotel")
    public void initPetHotelBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new PetHotelValidator());
    }

    @GetMapping("/owners/{ownerId}/{petId}/petHotels/new")
    public String createPetHotel(ModelMap model, Owner owner, Pet pet) {
        PetHotel petHotel = new PetHotel();
        petHotel.setOwner(owner);
        petHotel.setPet(pet);
        model.put("petHotel", petHotel);
        return PET_HOTEL_FORM;
    }

    @PostMapping("/owners/{ownerId}/{petId}/petHotels/new")
    public String savePetHotel(ModelMap model, @Valid PetHotel petHotel, BindingResult br, Owner owner, Pet pet) {
        if (br.hasErrors()) {
            model.put("petHotel", petHotel);
            return PET_HOTEL_FORM;
        } else {
            petHotel.setOwner(owner);
            petHotel.setPet(pet);
            petHotelService.save(petHotel);
            return "redirect:/owners/{ownerId}";
        }

    }

    @GetMapping(value = "/owners/{ownerId}/{petId}/petHotels/{id}/edit")
    public String initUpdateForm(@PathVariable("id") int id, ModelMap model) {
        PetHotel petHotel = petHotelService.getPetHotelById(id);
        model.put("petHotel", petHotel);
        return PET_HOTEL_FORM;
    }

    @PostMapping(value = "/owners/{ownerId}/{petId}/petHotels/{id}/edit")
    public String processUpdateForm(@ModelAttribute("petHotel") @Valid PetHotel petHotel, BindingResult br, Owner owner,
            Pet pet, @PathVariable("id") int id, ModelMap model) {
        if (br.hasErrors()) {
            model.put("petHotel", petHotel);
            return PET_HOTEL_FORM;
        } else {
            PetHotel petHotelToUpdate = petHotelService.getPetHotelById(id);
            BeanUtils.copyProperties(petHotel, petHotelToUpdate, "id", "owner", "pet");
            petHotelService.save(petHotelToUpdate);
            return "redirect:/owners/{ownerId}";
        }
    }

    @GetMapping("/owners/{ownerId}/{petId}/petHotels/{id}/delete")
    public String deletePetHotel(@PathVariable("id") int id) {
        petHotelService.deletePetHotel(id);
        return "redirect:/owners/{ownerId}";
    }
}
