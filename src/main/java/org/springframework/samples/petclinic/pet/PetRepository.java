package org.springframework.samples.petclinic.pet;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.samples.petclinic.model.BaseEntity;


@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {

	@Query("SELECT p FROM Pet p WHERE p.adoption = true")
	List<Pet> findPetsForAdoption() throws DataAccessException;

	@Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
	List<PetType> findPetTypes() throws DataAccessException;
	
	Pet findById(int id) throws DataAccessException;

}
