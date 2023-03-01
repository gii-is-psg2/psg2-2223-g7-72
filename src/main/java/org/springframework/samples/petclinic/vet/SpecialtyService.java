package org.springframework.samples.petclinic.vet;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyService {
    private SpecialtyRepository specialtyRepository;


	@Autowired
	public SpecialtyService(SpecialtyRepository specialtyRepository) {
		this.specialtyRepository= specialtyRepository;
	}		

    public List<Specialty> getAll(){
        return specialtyRepository.findAll().stream().collect(Collectors.toList());
    }

}
