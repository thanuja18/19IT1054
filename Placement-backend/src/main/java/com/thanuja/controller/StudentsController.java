package com.thanuja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.thanuja.model.Students;
import com.thanuja.service.StudentsService;

@RestController
public class StudentsController {

	@Autowired 
	StudentsService studentsSer;
	
	@GetMapping("/student")     //okay
	private List<Students> getAllStudents(){
		return studentsSer.getAllStudents();
	}
	
	//creating a get mapping that retrieves the detail of a specific book  
		@GetMapping("/student/{studentId}")      //okay
		private Students getBooks(@PathVariable("studentId") int id)   
		{  
		return studentsSer.getStudentById(id);  
		}  
		//creating a delete mapping that deletes a specified book  
		@DeleteMapping("/student/{studentId}")  
		private void deleteStudent(@PathVariable("studentId") int id)   
		{  
		studentsSer.delete(id);  
		}  
		
		@CrossOrigin(origins = "http://localhost:3000")
		@PostMapping("/students")  
		private int saveStudent(@RequestBody Students students)   
		{  
		studentsSer.saveOrUpdate(students);  
		return students.getStudentId();  
		}  
		
		@CrossOrigin(origins = "http://localhost:3000")
		@GetMapping("/students/login/{email}") 
		private Students getStudent(@PathVariable("email") String email) {
			return studentsSer.getStudentByEmail(email);
		}
		
//		@CrossOrigin(origins = "http://localhost:3000")
//		@PostMapping("/students")  
//		private int verify(@RequestBody Students students)   
//		{  
//		studentsSer.verify(students.getEmail(), students.getPassword())  
//		return students.getStudentId();  
//		} 
		
		@PutMapping("/students")  
		private Students update(@RequestBody Students students)   
		{  
		studentsSer.saveOrUpdate(students);  
		return students;  
		}  
		
}
