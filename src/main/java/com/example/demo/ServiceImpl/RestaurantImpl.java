package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.service.Dao;




@Service
public class RestaurantImpl implements Dao<Restaurant> {
	@Autowired
	RestaurantRepository restaurantrepository;
	@Override
	public Restaurant GetByName(String nom) {
		// TODO Auto-generated method stub
		Restaurant r=restaurantrepository.findBynom(nom);
		if(r==null) throw new RuntimeException("Restaurant Not Fund");
		
		return r;
	}

	@Override
	public List<Restaurant> GetAll() {
		// TODO Auto-generated method stub
		return restaurantrepository.findAll();
	}

	@Override
	public Restaurant Save(Restaurant t) {
		// TODO Auto-generated method stub
		Restaurant r=restaurantrepository.findBynom(t.getNom());
		if(r!=null) throw new RuntimeException("Restaurant Already Exists");
		return restaurantrepository.save(t);
	}

	@Override
	public void Delete(Integer id) {
		// TODO Auto-generated method stub
		Restaurant r=restaurantrepository.findByid(id);
		if(r==null) throw new RuntimeException("Restaurant Not Found");
		restaurantrepository.delete(r);
	}

	@Override
	public Restaurant Update(Integer id, Restaurant t) {
		// TODO Auto-generated method stub
		Restaurant r=restaurantrepository.findByid(id);
		if(r==null) throw new RuntimeException("Restaurant Not Found");
		r.setNom(t.getNom());
		return restaurantrepository.save(r);
	}
}
