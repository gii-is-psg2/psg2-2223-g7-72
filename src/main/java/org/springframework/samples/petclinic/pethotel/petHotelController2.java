package org.springframework.samples.petclinic.pethotel;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class petHotelController2 {
	
	private PetHotelService service;
	private OwnerService ownerService;
	private PetService petService;
	
	@Autowired
	public petHotelController2(PetHotelService service, OwnerService ownerService, PetService petService) {
		this.service = service;
		this.ownerService = ownerService;
		this.petService = petService;
	}

	@InitBinder("petHotel")
	public void initPetHotelBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(new PetHotelValidator());
	}
	
	@GetMapping("/petHotels/myProfile")
	public String myProfile(Principal principal) {
		Owner owner = ownerService.findOwnerByUsername(principal.getName());
		
		return "redirect:/owners/"+owner.getId();
	}
}
