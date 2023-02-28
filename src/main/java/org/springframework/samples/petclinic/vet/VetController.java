/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.vet;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
public class VetController {


	String VIEWS_VET_CREATE_OR_UPDATE_FORM = "vets/createOrUpdateVetForm";

	private final VetService vetService;

	private final SpecialtyService specialtyService;

	@Autowired
	public VetController(VetService clinicService, SpecialtyService specialtyService) {
		this.vetService = clinicService;
		this.specialtyService = specialtyService;
	}

	@GetMapping(value = { "/vets" })
	public String showVetList(Map<String, Object> model) {
		// Here we are returning an object of type 'Vets' rather than a collection of Vet
		// objects
		// so it is simpler for Object-Xml mapping
		Vets vets = new Vets();
		vets.getVetList().addAll(this.vetService.findVets());
		model.put("vets", vets);
		return "vets/vetList";
	}

	@GetMapping(value = { "/vets.xml"})
	public @ResponseBody Vets showResourcesVetList() {
		// Here we are returning an object of type 'Vets' rather than a collection of Vet
		// objects
		// so it is simpler for JSon/Object mapping
		Vets vets = new Vets();
		vets.getVetList().addAll(this.vetService.findVets());
		return vets;
	}

	@Transactional(readOnly = true)
	@GetMapping(value = "/vets/new")
	public String initCreationForm(Map<String, Object> model) {
		VetForm vetForm = new VetForm();
		model.put("specialties", this.specialtyService.getAll());
		model.put("vetForm", vetForm);
		return VIEWS_VET_CREATE_OR_UPDATE_FORM;
	}

	
	@Transactional(readOnly = true)
	@GetMapping(value = "/vets/{id}/edit")
	public String getEditForm(@PathVariable Integer id, Map<String, Object> model) {
		VetForm vetForm = new VetForm();
		vetForm.setVet(vetService.getVetById(id));
		vetForm.setSpecialties(specialtyService.getAll());
		model.put("vetForm", vetForm);
		model.put("specialties", specialtyService.getAll());
		return VIEWS_VET_CREATE_OR_UPDATE_FORM;
	}

	@Transactional
	@PostMapping(value = "/vets/new")
	public String processNewForm(@Valid VetForm vetForm, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_VET_CREATE_OR_UPDATE_FORM;
		}
		else {
			Vet vet = vetForm.getVet();
			vet.setSpecialtiesInternal(null);
			for (Specialty specialty: vetForm.getSpecialties()) {
				vet.addSpecialty(specialty);
			}
			vetService.saveVet(vet);
			return "redirect:/vets";
		}
	}


	@Transactional
	@PostMapping(value = "/vets/{id}/edit")
	public String processEditForm(@Valid VetForm vetForm, BindingResult result, @PathVariable Integer id) {
		if (result.hasErrors()) {
			return VIEWS_VET_CREATE_OR_UPDATE_FORM;
		}
		else {
			Vet vet = vetForm.getVet();
			vet.setSpecialtiesInternal(null);
			for (Specialty specialty: vetForm.getSpecialties()) {
				vet.addSpecialty(specialty);
			}
			vetService.saveVet(vet);
			return "redirect:/vets";
		}
	}

	@GetMapping("vets/{vetId}/delete")
	public String deleteVet(@PathVariable("vetId") int vetId) {
		this.vetService.deleteVet(vetId);
		return "redirect:/vets";
	}


}
