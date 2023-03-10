package org.springframework.samples.petclinic.notification;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NotificationRepository extends CrudRepository<Notification, Integer> {

	@Query("SELECT notification FROM Notification notification WHERE notification.pet.id =:petId")
	public List<Notification> findByPetId(@Param("petId") int petId);
}