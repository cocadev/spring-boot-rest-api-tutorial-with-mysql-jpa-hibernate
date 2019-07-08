package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Weapon;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Long>{

}
