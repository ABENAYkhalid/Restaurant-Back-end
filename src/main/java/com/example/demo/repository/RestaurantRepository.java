package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Restaurant;




@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	List<Restaurant> findAll();
	Restaurant findBynom(String nom);
	Restaurant findByid(Integer id);
}
