package org.springframework.samples.petclinic.vet;

import java.util.List;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VetForm extends BaseEntity {
    Vet vet;
    List<Specialty> specialties;
}
