package com.thanuja.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanuja.model.Offers;
import com.thanuja.repository.OffersRepository;

@Service
public class OffersService {
	
	@Autowired
	OffersRepository offersRep;
	
	public List<Offers> getAllOffers(){
		
		List<Offers> offers = new ArrayList<Offers>();
		offersRep.findAll().forEach(offersl -> offers.add(offersl));
		return offers;
	}
	
	public Offers getOffersById(int id)   
	{  
	return offersRep.findById(id).get();  
	} 
	
	public void saveOrUpdate(Offers offers)   
	{  
	offersRep.save(offers);  
	} 
	
	 
	
	public void delete(int id)   
	{  
	offersRep.deleteById(id);  
	}  
	
	public void update(Offers offers, int id)   
	{  
	offersRep.save(offers);  
	}  
}
