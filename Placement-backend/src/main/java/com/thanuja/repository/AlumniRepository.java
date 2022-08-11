package com.thanuja.repository;

import org.springframework.data.repository.CrudRepository;

import com.thanuja.model.Alumni;
import com.thanuja.model.Students;

public interface AlumniRepository extends CrudRepository<Alumni, Integer>{
	public Alumni findByEmail(String email);
}
