package com.examly.springapp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.DAO.AppDAO;
import com.examly.springapp.Model.webseries;

@RestController
public class AppController {
	
	@Autowired
	private AppDAO appdao;
		
	@GetMapping("/series")
	public List<webseries> getallseries(){
		return appdao.findAll();
	}
	
	@GetMapping("/series/id/{id}")
	public webseries getseriesbyid(@PathVariable int id) {
		Optional<webseries> result = appdao.findById(id);
		webseries series=null;
		if(result.isPresent()) {
			series=result.get();
		}else {
			throw new RuntimeException("Employee id not foundd "+id);
		}	
		return series;
	}
	
	@GetMapping("/series/name/{name}")
	public List<webseries> getseriesbyname(@PathVariable String name){
		return appdao.findbyname(name);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody webseries webseries) {
		appdao.save(webseries);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteseries(@PathVariable int id) {
		appdao.deleteById(id);
		return "Series Removed ! "+id;
				
	}
	
	@PostMapping("/addSeries")
	public void addseries(@RequestBody webseries webseries) {
		appdao.save(webseries);
	}
}
