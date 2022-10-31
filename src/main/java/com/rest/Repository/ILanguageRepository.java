package com.rest.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.Model.Language;

@Repository
public interface ILanguageRepository extends JpaRepository<Language, Long> {

}
