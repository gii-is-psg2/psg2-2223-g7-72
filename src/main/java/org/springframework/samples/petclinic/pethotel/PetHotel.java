package org.springframework.samples.petclinic.pethotel;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PetHotel extends BaseEntity{
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id")
	@NotNull
	private Owner owner;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pet_id")
	@NotNull
	private Pet pet;
	
	@Column(name = "start")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@NotNull
	private LocalDate start;
	
	@Column(name = "finish")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@NotNull
	private LocalDate finish;

}
