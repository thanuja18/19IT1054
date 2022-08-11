package com.thanuja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thanuja.model.Admin;
import com.thanuja.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService adSer;
	
	
	
	
	@GetMapping("/admin") 
	private List<Admin> getAllAdmin(){
		return adSer.getAllAdmin();
	}
	
	
	@GetMapping("/admin/{adminId}")  
	private Admin getBooks(@PathVariable("adminId") int id)   
	{  
	return adSer.getAdminById(id);
	}  
	
	@DeleteMapping("/admin/{adminId}")
	private void deleteAdmin(@PathVariable("adminId") int id) {
		adSer.delete(id);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/Admin/login/{email}") 
	private Admin getStudent(@PathVariable("email") String email) {
		return adSer.getAdminByEmail(email);
	}
	
	@PostMapping("/admins")  
	private int saveBook(@RequestBody Admin admins)   
	{  
	adSer.saveOrUpdate(admins);  
	return admins.getAdminId();  
	}  
	
	
}
