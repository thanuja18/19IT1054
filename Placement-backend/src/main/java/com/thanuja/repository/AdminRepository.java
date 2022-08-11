package com.thanuja.repository;

import org.springframework.data.repository.CrudRepository;

import com.thanuja.model.Admin;

public interface AdminRepository extends CrudRepository<Admin,Integer>{
	
	public Admin findByEmail(String email);
}
