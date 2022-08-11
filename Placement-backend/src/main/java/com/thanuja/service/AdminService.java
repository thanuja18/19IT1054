package com.thanuja.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanuja.model.Admin;
import com.thanuja.repository.AdminRepository;

@Service 
public class AdminService {

	@Autowired 
	AdminRepository adRep;
	
	public List<Admin> getAllAdmin(){
		
		List<Admin> admin= new ArrayList<Admin>();  
		adRep.findAll().forEach(admin1 -> admin.add(admin1)); 
		return admin; 
		
	}
	
	public Admin getAdminById(int id)   
	{  
	return adRep.findById(id).get();  
	}
	
	public Admin getAdminByEmail(String email) {
		return adRep.findByEmail(email);
	}
	
	public void saveOrUpdate(Admin admin)   
	{  
	adRep.save(admin);  
	} 
	
	public void delete(int id)   
	{  
	adRep.deleteById(id);  
	}  
	
	public void update(Admin admin, String id)   
	{  
	adRep.save(admin);  
	}  
}
