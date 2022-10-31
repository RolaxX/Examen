package com.rest.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rest.Exception.ResourceNotFoundException;
import com.rest.Repository.IAirportRepository;
import com.rest.Model.Airport;

@Service 
@Transactional 
public class AirportService implements IAirportService{
	
	@Autowired
	private IAirportRepository airportRepository;
	
	@Override
	public List<Airport> getAll() {
		return this.airportRepository.findAll();
	}
	@Override
	public Airport neww(Airport airport) {
		return airportRepository.save(airport);
	}
	
	
	@Override
	public Airport update(Airport airport) {
		Optional<Airport> employeedb = this.airportRepository.findById(airport.getId());
        
		if (employeedb.isPresent()) {
			Airport airportUpdate = employeedb.get();
			airportUpdate.setId(airport.getId());
			airportRepository.save(airportUpdate);
			return airportUpdate;
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + airport.getId());
		}
	}

	@Override
	public Airport getById(long airportId) {

		Optional<Airport> employeedb = this.airportRepository.findById(airportId);

		if (employeedb.isPresent()) {
			return employeedb.get();
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + airportId);
		}
	}

	@Override
	public void deleteAirport(long airportId) {
		Optional<Airport> employeedb = this.airportRepository.findById(airportId);

		if (employeedb.isPresent()) {
			this.airportRepository.delete(employeedb.get());
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + airportId);
		}

	}


}