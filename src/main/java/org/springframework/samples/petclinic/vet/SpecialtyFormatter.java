package org.springframework.samples.petclinic.vet;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class SpecialtyFormatter implements Formatter<Specialty> {

    private final SpecialtyService specialtyService;

	@Autowired
	public SpecialtyFormatter(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}

    @Override
    public String print(Specialty object, Locale locale) {
        return object.getName();
    }

    @Override
    public Specialty parse(String text, Locale locale) throws ParseException {
        List<Specialty> findSpecialty = this.specialtyService.getAll();
		for (Specialty specialty : findSpecialty) {
			if (specialty.getName().equals(text)) {
				return specialty;
			}
		}
		throw new ParseException("specialty not found: " + text, 0);
    }
}
