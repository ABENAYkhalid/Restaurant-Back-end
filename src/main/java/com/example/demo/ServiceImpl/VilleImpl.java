package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Restaurant;
import com.example.demo.entity.Ville;
import com.example.demo.entity.Zone;
import com.example.demo.repository.VilleRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.Dao;





@Service
public class VilleImpl implements Dao<Ville> {
	
	@Autowired
	VilleRepository villerepository;
	@Autowired
	ZoneRepository zonerepository;
	@Override
	public Ville GetByName(String nom) {
		// TODO Auto-generated method stub
		Ville v=villerepository.findBynom(nom);
		if(v==null) throw new RuntimeException("Ville Not Fund");
		
		return v;
	}

	@Override
	public List<Ville> GetAll() {
		// TODO Auto-generated method stub
		return villerepository.findAll();
	}

	@Override
	public Ville Save(Ville t) {
		// TODO Auto-generated method stub
		Ville v=villerepository.findBynom(t.getNom());
		if(v!=null) throw new RuntimeException("Ville Already Exists");
		return villerepository.save(t);
	}

	@Override
	public void Delete(Integer id) {
		// TODO Auto-generated method stub
		Ville v=villerepository.findByid(id);
		if(v==null) throw new RuntimeException("Ville Not Found");
		villerepository.delete(v);
	}

	@Override
	public Ville Update(Integer id, Ville t) {
		// TODO Auto-generated method stub
		Ville v=villerepository.findByid(id);
		if(v==null) throw new RuntimeException("Ville Not Found");
		v.setNom(t.getNom());
		return villerepository.save(v);
	}
	
	public List<Zone> getZonesByNomVille(String nomVille) {
        Ville Ville = villerepository.findBynom(nomVille);
        if (Ville==null) throw new RuntimeException("Ville non trouvée : " + nomVille); 
        return Ville.getZones();
        
    }
	
	public List<Restaurant> getRestoByCityAndZone(String nomVille, String nomZone) {

		Zone matchedZone = zonerepository.findByNomAndVille_Nom(nomZone, nomVille);
		if (matchedZone==null)throw new RuntimeException("Zone non trouvée : " + nomVille); 
		return matchedZone.getRestaurants();
		
	}
	
	

}
