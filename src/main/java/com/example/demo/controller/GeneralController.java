package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.General;
import com.example.demo.model.Weapon;
import com.example.demo.repository.GeneralRepository;
import com.example.demo.repository.WeaponRepository;

@RestController
public class GeneralController {
	
	@Autowired
    private GeneralRepository generalRepository;
	
	@Autowired
    private WeaponRepository weaponRepository;
	
	@GetMapping("/generals")
    public Page<General> getAllgenerals(Pageable pageable) {
        return generalRepository.findAll(pageable);
    }

    @PostMapping("/generals")
    public General createGeneral(@Valid @RequestBody General general) {
        return generalRepository.save(general);
    }
    
    @GetMapping("/howto/generals/{generalId}/weapons/{weaponId}")
    public Optional<Object> createGeneralWeapon(
    		
   		@PathVariable (value = "generalId") Long generalId,
   		@PathVariable (value = "weaponId") Long weaponId) {
    	
 	    if(!generalRepository.existsById(generalId)) {
            throw new ResourceNotFoundException("GeneralId " + generalId + " not found");
        }
	  
	    if(!weaponRepository.existsById(weaponId)) {
            throw new ResourceNotFoundException("WeaponId " + weaponId + " not found");
        }
   	 
        General general = generalRepository.findById(generalId).get();
        Weapon weapon = weaponRepository.findById(weaponId).get();

		 general.getWeapons().add(weapon);
		 weapon.getGenerals().add(general);

	     generalRepository.save(general);

         return null;
         
    }

}
