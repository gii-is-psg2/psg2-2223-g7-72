package org.springframework.samples.petclinic.notification;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	protected NotificationRepository notificationRepository;
	
	@Autowired
	NotificationService(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}
	
	@Transactional
	public void save(Notification notification) throws DataAccessException {
		notificationRepository.save(notification);
	}
}
