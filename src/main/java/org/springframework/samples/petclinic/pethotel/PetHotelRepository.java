package org.springframework.samples.petclinic.pethotel;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface PetHotelRepository extends CrudRepository<PetHotel, Integer> {

    public PetHotel findById(int id);

    public Collection<PetHotel> findBookingsByPetId(int petId);

}
