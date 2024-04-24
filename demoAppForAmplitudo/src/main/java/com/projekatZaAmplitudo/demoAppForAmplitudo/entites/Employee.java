package com.projekatZaAmplitudo.demoAppForAmplitudo.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "Employee")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "jmbg")
    private String jmbg;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "god_rodj")
    private Integer godinaRodjenja;

    @Column(name = "plata")
    private double plata;

    @ManyToOne
    @JoinColumn(name = "departman_id")
    private Departman departman;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "employee_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();
}
