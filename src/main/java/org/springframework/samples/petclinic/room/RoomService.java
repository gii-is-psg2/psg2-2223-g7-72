package org.springframework.samples.petclinic.room;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomService {

	protected RoomRepository repository;
	
	@Autowired
	RoomService(RoomRepository repository) {
		this.repository = repository;
	}
	
	@Transactional(readOnly = true)
	public Room getRoomById(Integer id) throws DataAccessException {
		return repository.findById(id);
	}
	
	@Transactional
	public void save(Room room) throws DataAccessException {
		repository.save(room);
	}

	
}
