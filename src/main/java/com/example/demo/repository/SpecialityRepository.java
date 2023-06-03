package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Speciality;


@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    Speciality findByNom(String nom);
}