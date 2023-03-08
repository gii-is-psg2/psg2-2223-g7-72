package org.springframework.samples.petclinic.notification;

import java.util.Collection;


import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.OwnerRepository;

public interface NotificationRepository extends CrudRepository<Notification, Integer> {


}