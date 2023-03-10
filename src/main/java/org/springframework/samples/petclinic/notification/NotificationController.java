package org.springframework.samples.petclinic.notification;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.samples.petclinic.user.User;
import org.springframework.samples.petclinic.user.UserService;
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
	public String initCreationForm(@PathVariable("petId") int petId, ModelMap model, Principal principal) {
		String username = principal.getName();
		Owner owner = this.ownerService.findOwnerByUsername(username);
		Pet pet = this.petService.findPetById(petId);
		if(owner.getId() != pet.getOwner().getId()) {
			Notification notification = new Notification();
			model.put("owner", owner);
			model.put("pet", pet);
			model.put("notification", notification);
			return NOTIFICATION_CREATE_OR_UPDATE_FORM;
		}
		else {
			return "redirect:/";
		}
	}
	
	@PostMapping(value = "/{petId}/new")
	public String processCreationForm(@PathVariable("petId") int petId, @Valid Notification notification, BindingResult result, ModelMap model, Principal principal) {
		String username = principal.getName();
		Owner owner = this.ownerService.findOwnerByUsername(username);
		Pet pet = this.petService.findPetById(petId);
		if(owner.getId() != pet.getOwner().getId()) {
			if (result.hasErrors()) {
				model.put("owner", owner);
				model.put("pet", pet);
				model.put("notification", notification);
				return NOTIFICATION_CREATE_OR_UPDATE_FORM;
			}
			else {
				owner.addNotification(notification);
				pet.addNotification(notification);
				this.notificationService.saveNotification(notification);
				return "redirect:/";
			}
		}
		else {
			return "redirect:/";
		}
	}
	
	@GetMapping(value = "/{ownerId}")
	public String showNotifications(@PathVariable("ownerId") int ownerId, ModelMap model) {
		Owner owner = this.ownerService.findOwnerById(ownerId);
		List<Pet> pets = owner.getPets();
		List<Notification> notifications = new ArrayList<>();
		for(Pet p : pets) {
			notifications.addAll(notificationService.findNotificationByPetId(p.getId()));
		}
		model.put("notifications", notifications);
		
		return "notifications/showNotifications";
	}
	
	
}
