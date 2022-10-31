package com.rest.Service;

import java.util.List;

import com.rest.Model.Language;

public interface ILanguageService {
	
	Language neww(Language language);
	
	Language update(Language language);
	
	List<Language> getAll();

	Language getById(long languageId);
	
	
	void deleteLanguage(long id);

}
