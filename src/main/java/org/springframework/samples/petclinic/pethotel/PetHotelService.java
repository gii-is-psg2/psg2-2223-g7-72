package org.springframework.samples.petclinic.pethotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PetHotelService {

	protected PetHotelRepository petHotelRepository;
	
	@Autowired
	PetHotelService(PetHotelRepository petHotelRepository) {
		this.petHotelRepository = petHotelRepository;
	}
	
	@Transactional(readOnly = true)
	public PetHotel getPetHotelById(Integer id) throws DataAccessException {
		return petHotelRepository.findById(id).get();
	}
	
	@Transactional 
	public void save(PetHotel pt) throws DataAccessException {
		petHotelRepository.save(pt);
	}
	
	@Transactional
	public void deletePetHotel(Integer id) throws DataAccessException {
		petHotelRepository.delete(petHotelRepository.findById(id).get());
	}
	
}
