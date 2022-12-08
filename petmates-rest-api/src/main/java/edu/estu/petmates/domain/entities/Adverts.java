package edu.estu.petmates.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Adverts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected Integer advert_id;

    @Column
    private LocalDateTime published_time;

    @Column
    private String description;

    @Column
    private String pet_name;

    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender.gender genderType;

    @Column
    private Date birthday;

    @Column
    private String advert_city_name;

    @Column
    private String advert_district_name;

    @Column
    private String address_line;

    @Enumerated(EnumType.STRING)
    @Column(name="pet_type")
    private Pet.petType petType;

    @Column
    private String pet_breed;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private User user;

    @Lob()
    @Column
    private Blob first_picture;

    @PrePersist
    public void prePersist() {
        published_time = LocalDateTime.now();
    }

}