package com.rest.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rest.Exception.ResourceNotFoundException;
import com.rest.Model.Country;
import com.rest.Repository.ICountryRepository;

@Service 
@Transactional 
public class CountryService implements ICountryService{
	
	@Autowired
	private ICountryRepository countryRepository;
	
	@Override
	public List<Country> getAll() {
		return this.countryRepository.findAll();
	}
	@Override
	public Country neww(Country country) {
		return countryRepository.save(country);
	}
	
	
	@Override
	public Country update(Country country) {
		Optional<Country> employeedb = this.countryRepository.findById(country.getId());
        
		if (employeedb.isPresent()) {
			Country countryUpdate = employeedb.get();
			countryUpdate.setId(country.getId());
			countryRepository.save(countryUpdate);
			return countryUpdate;
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id: " + country.getId());
		}
	}

	@Override
	public Country getById(long countryId) {

		Optional<Country> employeedb = this.countryRepository.findById(countryId);

		if (employeedb.isPresent()) {
			return employeedb.get();
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id: " + countryId);
		}
	}

	@Override
	public void deleteCountry(long countryId) {
		Optional<Country> employeedb = this.countryRepository.findById(countryId);

		if (employeedb.isPresent()) {
			this.countryRepository.delete(employeedb.get());
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + countryId);
		}

	}


}
