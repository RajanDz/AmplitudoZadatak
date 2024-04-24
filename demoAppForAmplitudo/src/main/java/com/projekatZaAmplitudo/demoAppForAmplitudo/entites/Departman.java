package com.projekatZaAmplitudo.demoAppForAmplitudo.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Departman")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Departman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "opis")
    private String opis;

    @Column(name = "prosjecna_plata")
    private Double prosjecnaPlata;

    @Column(name = "broj_radnika")
    private Integer brojRadnika;


}
