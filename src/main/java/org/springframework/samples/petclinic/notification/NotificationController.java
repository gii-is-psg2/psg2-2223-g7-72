package org.springframework.samples.petclinic.notification;

import java.security.Principal;
import java.util.List;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notifications")
public class NotificationController {
	
	private static final String NOTIFICATION_CREATE_OR_UPDATE_FORM = "notifications/createOrUpdateNotificationForm";

	private NotificationService notificationService;
	private OwnerService ownerService;
	private PetService petService;
	
	@Autowired
	public NotificationController(NotificationService notificationService, OwnerService ownerService, PetService petService) {
		this.notificationService = notificationService;
		this.ownerService = ownerService;
		this.petService = petService;
	}
	
	@GetMapping(value = "/{petId}/new")
	public String initCreationForm(Principal principal, @PathVariable("petId") int petId, ModelMap model) {
		Notification notification = new Notification();
		Owner owner = ownerService.findOwnerByUsername(principal.getName());
		List<Owner> owners = notification.getOwner();
		owners.add(owner);
		model.put("owner", owner);
		Pet pet = petService.findPetById(petId);
		List<Pet> pets = notification.getPet();
		pets.add(pet);
		model.put("pet", pet);
		model.put("notification", notification);
		return NOTIFICATION_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping(value = "/{petId}/new")
	public String processCreationForm(@Valid Notification notification, @PathVariable("petId") int petId, ModelMap model, BindingResult result) {
		if(result.hasErrors()) {
			model.put("notification", notification);
			return NOTIFICATION_CREATE_OR_UPDATE_FORM;
		}
		else {
			Notification notificationToUpdate = notification;
			BeanUtils.copyProperties(notification, notificationToUpdate, "id", "owner", "pet");
			this.notificationService.save(notificationToUpdate);
			return "redirect:/";
		}
	}
	
	
}
