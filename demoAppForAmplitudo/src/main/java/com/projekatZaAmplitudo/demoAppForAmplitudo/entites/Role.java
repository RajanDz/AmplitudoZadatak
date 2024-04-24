package com.projekatZaAmplitudo.demoAppForAmplitudo.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "Role")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "opis")
    private String opis;

}
