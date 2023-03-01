package org.springframework.samples.petclinic.room;

import org.springframework.dao.DataAccessException;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends CrudRepository<Room, Integer> {

	@Query("SELECT room FROM Room room WHERE room.id =:id")
	public Room findById(@Param("id") int id);
}
