package com.rest.Service;

import java.util.List;

import com.rest.Model.Airport;

public interface IAirportService {
	
	Airport neww(Airport airport);
	
	Airport update(Airport airport);
	
	List<Airport> getAll();

	Airport getById(long airportId);
	
	
	void deleteAirport(long id);

}
