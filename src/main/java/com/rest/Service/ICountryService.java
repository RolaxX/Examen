package com.rest.Service;

import java.util.List;

import com.rest.Model.Country;

public interface ICountryService {
	
Country neww(Country country);
	
	Country update(Country country);
	
	List<Country> getAll();

	Country getById(long countryId);
	
	void deleteCountry(long id);

}
