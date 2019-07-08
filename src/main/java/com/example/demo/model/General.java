package com.example.demo.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "generals")
public class General {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(max = 250)
    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "general_weapons",
            joinColumns = { @JoinColumn(name = "general_id") },
            inverseJoinColumns = { @JoinColumn(name = "weapon_id") })
    private Set<Weapon> weapons = new HashSet<>();


    public General() {

    }

    public General(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
