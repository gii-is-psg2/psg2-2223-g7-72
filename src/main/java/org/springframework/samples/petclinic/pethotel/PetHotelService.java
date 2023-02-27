package org.springframework.samples.petclinic.pethotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PetHotelService {


	protected PetHotelRepository repository;
	
	@Autowired
	PetHotelService(PetHotelRepository repository) {
		this.repository = repository;
	}
	
	@Transactional(readOnly = true)
	public PetHotel getPetHotelById(Integer id) throws DataAccessException{
		return repository.findById(id);
	}
	
	@Transactional 
	public void save(PetHotel pt) throws DataAccessException {
		repository.save(pt);
	}
	
}
