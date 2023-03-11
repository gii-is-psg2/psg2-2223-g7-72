package org.springframework.samples.petclinic.pethotel;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.stereotype.Service;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class PetHotelTest {

    @Autowired
    protected PetHotelService petHotelService;

    private PetHotel makeBooking() {

        PetHotel book = new PetHotel();
        book.setStart(LocalDate.of(2023, 3, 9));
        book.setFinish(LocalDate.of(2023, 3, 16));

        return book;
    }

    @Test
    public void shouldSaveBooking() {

        int expectedBookings = 4;
        int petId = 1;
        Pet pet = new Pet();
        pet.setId(1);
        Owner owner = new Owner();
        owner.setId(1);
        PetHotel newBook = new PetHotel();
        newBook.setPet(pet);
        newBook.setOwner(owner);
        newBook.setStart(LocalDate.of(2023, 4, 20));
        newBook.setFinish(LocalDate.of(2023, 4, 21));

        petHotelService.save(newBook);
        int actualBookings = petHotelService.getPetHotelByPetId(petId).size();

        assertEquals(expectedBookings, actualBookings);
    }

    @Test
    public void shouldNotSaveBooking() {

        int expectedBookings = 3;
        int petId = 1;
        Pet pet = new Pet();
        pet.setId(1);
        Owner owner = new Owner();
        owner.setId(1);
        PetHotel newBook = new PetHotel();
        newBook.setPet(pet);
        newBook.setOwner(owner);
        newBook.setStart(LocalDate.of(2023, 4, 1));
        newBook.setFinish(LocalDate.of(2023, 4, 30));

        petHotelService.save(newBook);
        int actualBookings = petHotelService.getPetHotelByPetId(petId).size();

        assertEquals(expectedBookings, actualBookings);
    }

    @Test
    public void bookingIsNotConcurrent() {
        PetHotel book = makeBooking();

        PetHotel newBook = new PetHotel();
        newBook.setStart(LocalDate.of(2023, 4, 11));
        newBook.setFinish(LocalDate.of(2023, 4, 19));

        assertFalse(petHotelService.isBookingConcurrent(book, newBook));

    }

    @Test
    public void bookingIsConcurrentNewBookingStartingDateBetweenBooking() {
        PetHotel book = makeBooking();

        PetHotel newBook = new PetHotel();
        newBook.setStart(LocalDate.of(2023, 3, 11));
        newBook.setFinish(LocalDate.of(2023, 3, 19));

        assertTrue(petHotelService.isBookingConcurrent(book, newBook));

    }

    @Test
    public void bookingIsConcurrentNewBookingFinishDateBetweenBooking() {
        PetHotel book = makeBooking();

        PetHotel newBook = new PetHotel();
        newBook.setStart(LocalDate.of(2023, 3, 7));
        newBook.setFinish(LocalDate.of(2023, 3, 11));

        assertTrue(petHotelService.isBookingConcurrent(book, newBook));

    }

    @Test
    public void bookingIsConcurrentNewBookingStartingFinishDateBetweenBookingInside() {
        PetHotel book = makeBooking();

        PetHotel newBook = new PetHotel();
        newBook.setStart(LocalDate.of(2023, 3, 11));
        newBook.setFinish(LocalDate.of(2023, 3, 18));

        assertTrue(petHotelService.isBookingConcurrent(book, newBook));

    }

    @Test
    public void bookingIsConcurrentNewBookingStartingFinishDateBetweenBookingOutside() {
        PetHotel book = makeBooking();

        PetHotel newBook = new PetHotel();
        newBook.setStart(LocalDate.of(2023, 3, 1));
        newBook.setFinish(LocalDate.of(2023, 3, 31));

        assertTrue(petHotelService.isBookingConcurrent(book, newBook));

    }

}
