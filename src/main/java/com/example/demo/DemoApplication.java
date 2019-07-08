package com.example.demo;

import com.example.demo.model.General;
import com.example.demo.model.Weapon;
import com.example.demo.repository.GeneralRepository;
import com.example.demo.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private WeaponRepository weaponRepository;

	@Autowired
	private GeneralRepository generalRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Cleanup the tables
		generalRepository.deleteAllInBatch();
		weaponRepository.deleteAllInBatch();

		// =======================================

		// Create a Post
		General general = new General("Hibt");

		// Create two tags
		Weapon weapon1 = new Weapon("Spring Boot");
		Weapon weapon2 = new Weapon("Hibernate");


		// Add tag references in the post
		general.getWeapons().add(weapon1);
		general.getWeapons().add(weapon2);

		// Add post reference in the tags
		weapon1.getGenerals().add(general);
		weapon2.getGenerals().add(general);

		generalRepository.save(general);

		// =======================================

	}
}