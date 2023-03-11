package org.springframework.samples.petclinic.pethotel;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PetHotelService {

    private final PetHotelRepository petHotelRepository;

    @Autowired
    PetHotelService(PetHotelRepository petHotelRepository) {
        this.petHotelRepository = petHotelRepository;
    }

    @Transactional(readOnly = true)
    public PetHotel getPetHotelById(Integer id) throws DataAccessException {
        return petHotelRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public Collection<PetHotel> getPetHotelByPetId(Integer petId) throws DataAccessException {
        return petHotelRepository.findBookingsByPetId(petId);
    }

    @Transactional
    public void save(PetHotel petHotel) throws DataAccessException {
        Collection<PetHotel> bookings = getPetHotelByPetId(petHotel.getPet().getId());
        if (!concurrentBookingsPresent(bookings, petHotel)) {
            petHotelRepository.save(petHotel);
        }
    }

    @Transactional
    public void deletePetHotel(Integer id) throws DataAccessException {
        petHotelRepository.delete(petHotelRepository.findById(id).get());
    }

    public boolean concurrentBookingsPresent(Collection<PetHotel> petBookings, PetHotel newBook) {
        return petBookings.stream().anyMatch(book -> isBookingConcurrent(book, newBook));
    }

    public boolean isBookingConcurrent(PetHotel book, PetHotel newBook) {
        if ((newBook.getStart().isBefore(book.getStart()) && newBook.getFinish().isBefore(book.getStart()))
                || (book.getFinish().isBefore(newBook.getStart()) && book.getFinish().isBefore(newBook.getFinish()))) {
            return false;
        }
        return true;
    }

}
