package com.thanuja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.multipart.MultipartFile;

import com.thanuja.model.SelectedStudents;


public interface SelectedRepository extends CrudRepository<SelectedStudents, Integer>{
//	public SelectedStudents findByName(String name);
//	public int findByCompany(String company);
//	public void SaveStudentToDB(MultipartFile file, String reg, String company, String basePackage);
}
