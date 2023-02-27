package org.springframework.samples.petclinic.pethotel;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PetHotelValidator implements Validator{

	private static final String START = "La fecha no puede ser anterior a la actual";
	private static final String FINISH = "La fecha de salia no puede ser anterior a la de entrada";

	@Override
	public boolean supports(Class<?> clazz) {
		return PetHotel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		PetHotel petHotel = (PetHotel) obj;
		LocalDate start = petHotel.getStart();
		LocalDate finish = petHotel.getFinish();
		
		if(start.isBefore(LocalDate.now())) {
			errors.rejectValue("start", START, START);
		} 
		
		else if(start.isAfter(finish)) {
			errors.rejectValue("finish", FINISH, FINISH);
		}
	}
} 
