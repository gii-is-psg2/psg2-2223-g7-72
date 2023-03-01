package org.springframework.samples.petclinic.pethotel;



import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;



public interface PetHotelRepository extends Repository<PetHotel, Integer> {

	void save(PetHotel petHotel) throws DataAccessException;
	
	@Query("SELECT petHotel FROM PetHotel petHotel WHERE petHotel.id =:id")
	public PetHotel findById(@Param("id") int id);
	
	
}
