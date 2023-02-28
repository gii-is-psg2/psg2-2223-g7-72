package org.springframework.samples.petclinic.pethotel;


import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owners/{ownerId}/{petId}/petHotels")
public class PetHotelController {
	
	private final String PET_HOTEL_FORM = "petHotels/createOrUpdatePetHotelForm";
	
	private PetHotelService service;
	private OwnerService ownerService;
	private PetService petService;
	
	@Autowired
	public PetHotelController(PetHotelService service, OwnerService ownerService, PetService petService) {
		this.service = service;
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
	
	@GetMapping("/new")
	public String createPetHotel(ModelMap model,Owner owner, Pet pet) {
		PetHotel petHotel = new PetHotel();
		petHotel.setOwner(owner);
		petHotel.setPet(pet);
		model.put("petHotel", petHotel);
		return PET_HOTEL_FORM;
	}
	
	@PostMapping("/new")
	public String savePetHotel(ModelMap model, @Valid PetHotel petHotel, BindingResult br, Owner owner, Pet pet) {
		if(br.hasErrors()) {
			model.put("petHotel", petHotel);
			return PET_HOTEL_FORM;
		}
		else {
			petHotel.setOwner(owner);
			petHotel.setPet(pet);
			service.save(petHotel);
			return "redirect:/owners/{ownerId}";
		}
		
	}
	
	@GetMapping(value = "/{id}/edit")
	public String initUpdateForm(@PathVariable("id") int id, ModelMap model) {
		PetHotel petHotel = service.getPetHotelById(id);
		model.put("petHotel", petHotel);
		return PET_HOTEL_FORM;
	}
	
	
	@PostMapping(value = "/{id}/edit")
	public String processUpdateForm(@ModelAttribute("petHotel") @Valid PetHotel petHotel, BindingResult br, Owner owner, Pet pet, @PathVariable("id") int id, ModelMap model) {
		if(br.hasErrors()) {
			model.put("petHotel", petHotel);
			return PET_HOTEL_FORM;
		} else {
			PetHotel petHotelToUpdate = service.getPetHotelById(id);
			BeanUtils.copyProperties(petHotel, petHotelToUpdate, "id", "owner", "pet");
			service.save(petHotelToUpdate);
			return "redirect:/owners/{ownerId}";
		}
	}
}