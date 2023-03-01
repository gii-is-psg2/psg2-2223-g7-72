package org.springframework.samples.petclinic.room;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pethotel.PetHotel;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Room extends BaseEntity {

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
//	@NotNull
//	private List<PetHotel> petHotel;
//	
//	public List<PetHotel> getPetHotels() {
//		if(this.petHotel == null) {
//			this.petHotel = new ArrayList<>();
//		}
//		return this.petHotel;
//	}
}
