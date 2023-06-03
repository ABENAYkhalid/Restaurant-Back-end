package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.Dao;




@Service
public class ZoneImpl implements Dao<Zone>{
	@Autowired
	ZoneRepository zonerepository;

	@Override
	public Zone GetByName(String nom) {
		// TODO Auto-generated method stub
		Zone z=zonerepository.findBynom(nom);
		if(z==null) throw new RuntimeException("Zone Not Found");
		
		return z;
	}

	@Override
	public List<Zone> GetAll() {
		// TODO Auto-generated method stub
		
		return zonerepository.findAll();
				
	}

	@Override
	public Zone Save(Zone t) {
		// TODO Auto-generated method stub
		Zone z=zonerepository.findBynom(t.getNom());
		if(z!=null) throw new RuntimeException("Zone Already Exists");
		return zonerepository.save(t);
	}

	@Override
	public void Delete(Integer id) {
		// TODO Auto-generated method stub
		Zone z=zonerepository.findByid(id);
		if(z==null) throw new RuntimeException("Zone Not Found");
		zonerepository.delete(z);
	}

	@Override
	public Zone Update(Integer id, Zone t) {
		// TODO Auto-generated method stub
		Zone z=zonerepository.findByid(id);
		if(z==null) throw new RuntimeException("Zone Not Found");
		z.setNom(t.getNom());
		return zonerepository.save(z);
	}

}
