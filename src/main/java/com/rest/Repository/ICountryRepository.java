package com.rest.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.Model.Country;

@Repository
public interface ICountryRepository extends JpaRepository<Country, Long> {

}
