package com.rest.Controller;

import java.util.List;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rest.Exception.Mensaje;
import com.rest.Model.Country;
import com.rest.Service.ICountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {
	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private	ICountryService countryservice;

	@GetMapping("/FindAll")
	public ResponseEntity<?> getAll() {
		List<Country> lista = countryservice.getAll();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin resgistros en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(countryservice.getAll());
	}

	@GetMapping("/FindById/{id}")
	public ResponseEntity<Country> getbyId(@PathVariable long id) {
		return ResponseEntity.ok().body(countryservice.getById(id));
	
	}
	
	@PostMapping("/New")
	public ResponseEntity<Country>neww(@RequestBody Country country) {
		return ResponseEntity.ok().body(this.countryservice.neww(country));
	}
	
	@PutMapping("/Update/{id}")
	public ResponseEntity<Country> update(@PathVariable long id, @RequestBody Country country) {
		country.setId(id);
		return ResponseEntity.ok().body(this.countryservice.update(country));
	}
	
	@DeleteMapping("/Delete/{id}")
	public HttpStatus delete(@PathVariable long id) {
		this.countryservice.deleteCountry(id);
		return HttpStatus.OK;
	}
	
	
	
}