package org.springframework.samples.petclinic.notification;

import javax.persistence.ManyToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Getter
@Setter
@Entity
@Table(name = "notification")
public class Notification extends BaseEntity {

    @NotEmpty
    private String comment;
    
    @ManyToMany
    @JoinTable(name="notification_owner", joinColumns = @JoinColumn(name = "notification_id"), inverseJoinColumns = @JoinColumn(name="owner_id"))
    private List<Owner> owner;

    @ManyToMany
    @JoinTable(name="notification_pet", joinColumns = @JoinColumn(name = "notification_id"),inverseJoinColumns = @JoinColumn(name="pet_id"))
    private List<Pet> pet;
    
}