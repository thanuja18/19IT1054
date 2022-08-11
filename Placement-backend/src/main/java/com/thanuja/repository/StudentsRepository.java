package com.thanuja.repository;


import org.springframework.data.repository.CrudRepository;


import com.thanuja.model.Students;


public interface StudentsRepository extends CrudRepository<Students, Integer> {

	public Students findByEmail(String email);
}
