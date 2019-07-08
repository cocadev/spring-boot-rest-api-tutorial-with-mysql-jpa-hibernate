//package com.example.demo.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.*;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.demo.model.General;
//import com.example.demo.repository.GeneralRepository;
//import com.example.demo.repository.WeaponRepository;
//
//@RestController
//public class GeneralController {
//	
//	@Autowired
//    private GeneralRepository generalRepository;
//	
//	@Autowired
//    private WeaponRepository weaponRepository;
//	
//	@GetMapping("/generals")
//    public Page<General> getAllgenerals(Pageable pageable) {
//        return generalRepository.findAll(pageable);
//    }
//
//    @PostMapping("/generals")
//    public General createGeneral(@Valid @RequestBody General general) {
//        return generalRepository.save(general);
//    }
//
//}
