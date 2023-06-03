package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceImpl.ZoneImpl;
import com.example.demo.entity.Zone;




@RestController
@RequestMapping("/api/zones")
public class ZoneController {
    
    @Autowired
    ZoneImpl zoneimpl;
    
    @GetMapping(path =  "/{name}")
    public Zone getAllZones(@PathVariable String name) {
        return zoneimpl.GetByName(name);
    }
    
    @GetMapping
    public List<Zone> Getall(){
    	return zoneimpl.GetAll();
    }
    
    @PostMapping
    public Zone Save(@RequestBody Zone zone) {
    	return zoneimpl.Save(zone);
    }
    
    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Integer id) {
    	zoneimpl.Delete(id);
    }
    
    @PutMapping("/{id}")
    public Zone Update(@PathVariable Integer id,@RequestBody Zone zone) {
    	return zoneimpl.Update(id, zone);
    }
}