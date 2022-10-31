package com.rest.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.Model.Airport;

@Repository
public interface IAirportRepository extends JpaRepository<Airport, Long> {

}
