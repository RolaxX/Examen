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
import com.rest.Model.Airport;
import com.rest.Service.IAirportService;

@RestController
@RequestMapping("/airports")
public class AirportController {
	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private	IAirportService airportservice;

	@GetMapping("/FindAll")
	public ResponseEntity<?> getAll() {
		List<Airport> lista = airportservice.getAll();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin resgistros en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(airportservice.getAll());
	}

	@GetMapping("/FindById/{id}")
	public ResponseEntity<Airport> getbyId(@PathVariable long id) {
		return ResponseEntity.ok().body(airportservice.getById(id));
	
	}
	
	@PostMapping("/New")
	public ResponseEntity<Airport>neww(@RequestBody Airport airport) {
		return ResponseEntity.ok().body(this.airportservice.neww(airport));
	}
	
	@PutMapping("/UpdateAirport/{id}")
	public ResponseEntity<Airport> update(@PathVariable long id, @RequestBody Airport airport) {
		airport.setId(id);
		return ResponseEntity.ok().body(this.airportservice.update(airport));
	}
	
	@DeleteMapping("/DeleteAirport/{id}")
	public HttpStatus delete(@PathVariable long id) {
		this.airportservice.deleteAirport(id);
		return HttpStatus.OK;
	}
	
	
	
}