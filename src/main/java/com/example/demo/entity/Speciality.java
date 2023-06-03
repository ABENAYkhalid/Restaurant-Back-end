package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Speciality {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column 
	private String nom;
	@ManyToMany(mappedBy = "specialities")
    private Set<Restaurant> restaurants=new HashSet<>();
	public Object getNom() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setNom(Object nom2) {
		// TODO Auto-generated method stub
		
	}

}
