package com.example.demo.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "weapons")
public class Weapon {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @NaturalId
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "weapons")
    private Set<General> generals = new HashSet<>();

    public Weapon() {

    }

    public Weapon(String name) {
        this.name = name;
    }
}
