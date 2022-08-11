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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.thanuja.model.Offers;
import com.thanuja.service.OffersService;

@RestController
public class OffersController {

	@Autowired
	OffersService offersSer;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/offer")    //okay
	private List<Offers> getAllOffers(){
		return offersSer.getAllOffers();
	}
	
	@GetMapping("/offer/{oId}")   //okay
	private Offers getOffers(@PathVariable("oId") int oId) {
		return offersSer.getOffersById(oId);
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/offers")   //okay
	private int save(@RequestBody Offers offer) {
		offersSer.saveOrUpdate(offer);
		return offer.getoId();
	}
	
	
	//creating a delete mapping that deletes a specified book  
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/offer/{oId}")     //okay
	private void deleteOffer(@PathVariable("oId") int id) {
		offersSer.delete(id);
	}
	
	
	@PostMapping("/offers/{oId}")   
	private int updateOffer(@PathVariable("oId") int id ,@RequestBody Offers offer) {
		Offers off = offersSer.getOffersById(id); 
		offersSer.saveOrUpdate(off);
		return offer.getoId();
	}
	
	//http://localhost:8080/offers
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/offers/edit/{oId}")  
	private int update(@PathVariable("oId") int id,@RequestBody Offers offers)   
	{  
		offersSer.update(offers, id);
		return offers.getoId();
	}  
	
	
} 
