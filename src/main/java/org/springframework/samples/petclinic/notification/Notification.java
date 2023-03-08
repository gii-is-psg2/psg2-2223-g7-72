package org.springframework.samples.petclinic.notification;

import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;
import lombok.Getter;
import lombok.Setter;

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

   /*  @ManyToMany ( name="notification_owner" ,JoinColumn = "notification_id", inverseJoinColumn = "onwer_id")
    private Owner owner;

    @ManyToMany ( name="notification_pet" ,JoinColumn = "notification_id", inverseJoinColumn = "pet_id")
    private Pet pet;
 */
}