package com.thanuja.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanuja.model.Alumni;
import com.thanuja.repository.AlumniRepository;

@Service 
public class AlumniService {
	
	@Autowired
	AlumniRepository rep;
	
	
	public List<Alumni> getAll(){
		List<Alumni> list = new ArrayList<Alumni>();
		rep.findAll().forEach(Alu ->{
			list.add(Alu);
		});
		
		return list;
	}
	
	public Alumni findByEmail(String email) {
		return rep.findByEmail(email);
	}
	
	public void save(Alumni alu) {
		rep.save(alu);
	}

}
