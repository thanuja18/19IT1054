package com.thanuja.service;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.thanuja.model.SelectedStudents;
import com.thanuja.repository.SelectedRepository;

@Service 
public class SelectedService {
	@Autowired
	SelectedRepository selected;
	
	
	public List<SelectedStudents> getAll(){
		List<SelectedStudents> stud = new ArrayList<SelectedStudents>();
		selected.findAll().forEach(studL -> stud.add(studL));
//		Decoder decoder = Base64.getDecoder();
		
				
//		System.out.println(new String(bytes));
//		selected.findAll().forEach(studL ->{
//			byte[] bytes = decoder.decode(studL.getImage());
//			String img = new String(bytes);
//			studL.setImage(img);
//		});
		
		return stud;
	}
	
	
	public void SaveStudentToDB(MultipartFile file, String reg, String company, String basePackage)
	{
		SelectedStudents s = new SelectedStudents();
		s.setBasePackage(basePackage);
		s.setCompany(company);
		s.setReg(reg);
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			s.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		selected.save(s);
	}
	
	public void SaveOrUpdate(SelectedStudents stud) {
		selected.save(stud);
	}
	
	public long getCount() {
		return selected.count();
	}
	
//	public int getCompNo(String company) {
//		return selected.findByCompany(company);
//	}
	
	
}
