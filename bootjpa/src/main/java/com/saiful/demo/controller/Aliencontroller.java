package com.saiful.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.saiful.demo.dao.AlienRepo;
import com.saiful.demo.model.Alien;

@RestController
public class Aliencontroller
{
	@Autowired
	AlienRepo repo;
@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
		
		
	}
@DeleteMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable int aid)
    {
    	Alien a=repo.getOne(aid);
    	repo.delete(a);
		return "deleted";
    }
@PostMapping("/alien")
	public Alien addAlien(Alien alien)
	{
	repo.save(alien);
		return alien;
		
	}
@PutMapping("/alien")
public Alien saveOrUpdateAlien(Alien alien)
{
repo.save(alien);
	return alien;
	
}

/*@RequestMapping("/getAlien")
public ModelAndView getAlien(@RequestParam int aid)
{
	ModelAndView mv=new ModelAndView("show.jsp");
Alien alien =repo.findById(aid).orElse(new Alien());

//System.out.println(repo.findByTech("java"));
//System.out.println(repo.findByAidGreaterThan(102));
System.out.println(repo.findByTechSorted("java"));
mv.addObject(alien);
	return mv;
	
}*/
@GetMapping(path="/aliens")

public List<Alien> getAliens()
{
	
	return repo.findAll();
	
}
@RequestMapping("/alien/{aid}")

public Optional<Alien> getAlien(@PathVariable("aid")int aid)
{
	
	return repo.findById(aid);
	
}
}


