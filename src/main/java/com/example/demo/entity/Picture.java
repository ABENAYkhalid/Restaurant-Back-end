package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Picture {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column 
	private String url;
	@ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
