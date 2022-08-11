package com.thanuja.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thanuja.model.Students;
import com.thanuja.repository.StudentsRepository;

@Service  

public class StudentsService {
	@Autowired  
	StudentsRepository studentsRep;
	
	public List<Students> getAllStudents(){
		
		List<Students> students = new ArrayList<Students>();  
		studentsRep.findAll().forEach(students1 -> students.add(students1));  
		return students; 
		
	}
	
	public Students getStudentById(int id)   
	{  
	return studentsRep.findById(id).get();  
	}  
	
	public Students getStudentByEmail(String email) {
		return studentsRep.findByEmail(email);
	}
	
	public void saveOrUpdate(Students students)   
	{  
	studentsRep.save(students);  
	} 
	
	public void delete(int id)   
	{  
	studentsRep.deleteById(id);  
	}  
	
	public void update(Students students, String id)   
	{  
	studentsRep.save(students);  
	}  
}
