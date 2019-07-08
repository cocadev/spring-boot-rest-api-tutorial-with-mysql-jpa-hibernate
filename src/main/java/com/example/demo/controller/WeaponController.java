//package com.example.demo.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.*;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.demo.exception.ResourceNotFoundException;
//import com.example.demo.model.General;
//import com.example.demo.model.Weapon;
//import com.example.demo.repository.GeneralRepository;
//import com.example.demo.repository.WeaponRepository;
//
//@RestController
//public class WeaponController {
//
//	 @Autowired
//     private GeneralRepository generalRepository;
//
//     @Autowired
//     private WeaponRepository weaponRepository;
//     
//     @GetMapping("/weapons")
//     public Page<Weapon> getAllweapons(Pageable pageable) {
//         return weaponRepository.findAll(pageable);
//     }
//
//     @PostMapping("/weapons")
//     public Weapon createWeapon(@Valid @RequestBody Weapon weapon) {
//         return weaponRepository.save(weapon);
//     }
//    
//}
