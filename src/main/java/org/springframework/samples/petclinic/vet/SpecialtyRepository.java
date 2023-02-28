package org.springframework.samples.petclinic.vet;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends CrudRepository<Specialty, Integer>{
    
    Collection<Specialty> findAll() throws DataAccessException;
}
