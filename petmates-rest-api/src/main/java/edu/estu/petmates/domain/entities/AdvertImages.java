package edu.estu.petmates.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class AdvertImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected Integer image_id;

    @ManyToOne
    @JoinColumn(name = "advert_id")
    private Adverts adverts;

    @Lob()
    @Column
    private Blob image;
}
