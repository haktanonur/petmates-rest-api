package edu.estu.petmates.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class PetBreeds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected Integer pet_breed_id;

    @Column
    private String pet_breed_name;

    @Enumerated(EnumType.STRING)
    @Column(name="pet_type")
    private Pet.petType petType;

}
