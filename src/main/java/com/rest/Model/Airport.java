package com.rest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airport_generator")
    @SequenceGenerator(name="airport_generator", sequenceName = "airport_seq")
	
	private long id;
	
	@Column(name="name")
	
	private String name;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	


	

}