package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Speciality;
import com.example.demo.repository.SpecialityRepository;
import com.example.demo.service.Dao;



@Service
public class SpecialityServiceImp implements Dao<Speciality> {

    private final SpecialityRepository specialityRepository;

    @Autowired
    public SpecialityServiceImp(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    public Speciality GetById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    public List<Speciality> GetAll() {
        return specialityRepository.findAll();
    }

    public Speciality Save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    public void Delete(Long id) {
        specialityRepository.deleteById(id);
    }

    public Speciality Update(Long id, Speciality speciality) {
        Speciality existingSpeciality = specialityRepository.findById(id).orElse(null);
        if (existingSpeciality != null) {
            existingSpeciality.setNom(speciality.getNom());
            return specialityRepository.save(existingSpeciality);
        }
        return null;
    }

	@Override
	public Speciality GetByName(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Speciality Update(Integer id, Speciality t) {
		// TODO Auto-generated method stub
		return null;
	}
}