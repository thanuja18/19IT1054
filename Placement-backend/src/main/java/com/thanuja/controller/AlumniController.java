package com.thanuja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thanuja.model.Alumni;
import com.thanuja.service.AlumniService;

@RestController
public class AlumniController {
	
	@Autowired
	AlumniService serv;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/Alumni/Add")
	public void add(@RequestBody Alumni alu) {
		serv.save(alu);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/Alumni/login/{email}")
	public Alumni get(@PathVariable("email") String email) {
		return serv.findByEmail(email);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/AlumniNote")
	public List<Alumni> getNote() {
		return serv.getAll();
	}
	
}
