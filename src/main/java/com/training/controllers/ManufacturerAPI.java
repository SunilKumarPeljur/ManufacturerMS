package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.repository.Manufacturer;
import com.training.repository.ManufacturerRepository;

@RestController
public class ManufacturerAPI {

	@Autowired
	private ManufacturerRepository manufacturerRepo;

	@RequestMapping(value = "/api/manufacturer", method = RequestMethod.POST)
	public ResponseEntity<Manufacturer> add(@RequestBody Manufacturer manufacturer) {
		manufacturerRepo.save(manufacturer);
		return new ResponseEntity<Manufacturer>(manufacturer, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/api/manufacturer/{id}", method = RequestMethod.GET)
	public ResponseEntity<Manufacturer> find(@PathVariable(value = "id") Integer id) {
		Manufacturer manufacturer = manufacturerRepo.findOne(id);
		return new ResponseEntity<Manufacturer>(manufacturer, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/manufacturer", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Manufacturer>> findAll() {
		return new ResponseEntity<List<Manufacturer>>(manufacturerRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/manufacturer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {
		manufacturerRepo.delete(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "/api/manufacturer/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable(value = "id") Integer id, @RequestBody Manufacturer manufac) {
		Manufacturer man = manufacturerRepo.findOne(id);
		if (man != null) {
			man.setInceptionDate(manufac.getInceptionDate());
			man.setName(manufac.getName());
			man.setIsActive(manufac.getIsActive());
			manufacturerRepo.save(man);
		} else {
			return new ResponseEntity<String>("Manufacturer not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Updated", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/manufacturer/active", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Manufacturer>> findAllActive() {
		return new ResponseEntity<List<Manufacturer>>(manufacturerRepo.getAllActiveManufacturers(), HttpStatus.OK);
	}
}
