package com.rest.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rest.Exception.ResourceNotFoundException;
import com.rest.Model.Language;
import com.rest.Repository.ILanguageRepository;

@Service 
@Transactional 
public class LanguageService implements ILanguageService{
	
	@Autowired
	private ILanguageRepository languageRepository;
	
	@Override
	public List<Language> getAll() {
		return this.languageRepository.findAll();
	}
	@Override
	public Language neww(Language language) {
		return languageRepository.save(language);
	}
	
	
	@Override
	public Language update(Language language) {
		Optional<Language> employeedb = this.languageRepository.findById(language.getId());
        
		if (employeedb.isPresent()) {
			Language languageUpdate = employeedb.get();
			languageUpdate.setId(language.getId());
			languageRepository.save(languageUpdate);
			return languageUpdate;
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + language.getId());
		}
	}

	@Override
	public Language getById(long languageId) {

		Optional<Language> employeedb = this.languageRepository.findById(languageId);

		if (employeedb.isPresent()) {
			return employeedb.get();
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + languageId);
		}
	}

	@Override
	public void deleteLanguage(long languageId) {
		Optional<Language> employeedb = this.languageRepository.findById(languageId);

		if (employeedb.isPresent()) {
			this.languageRepository.delete(employeedb.get());
		} else {
			throw new ResourceNotFoundException("Registro no encontrado con id : " + languageId);
		}

	}


}