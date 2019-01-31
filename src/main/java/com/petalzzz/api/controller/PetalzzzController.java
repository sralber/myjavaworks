package com.petalzzz.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petalzzz.api.dto.UserTo;
import com.petalzzz.api.repository.PetalzzzRepository;

@RestController
@RequestMapping(path="/user")


public class PetalzzzController {
	@Autowired
	private PetalzzzRepository repository;
    @GetMapping
	public String check()
	{
		return"Welcome to Petalzzz";
	}
    @GetMapping(path="/getUsers")
    @CrossOrigin(origins= {"http://localhost:3000"})
    public List<UserTo>  getUsers(){
    	return repository.getUserNAmes();
    }
    
    @RequestMapping(value="/createUser/{userName}/{phone}")
    @CrossOrigin(origins= {"http://localhost:3000"})
    public String  addUser(@PathVariable String userName, @PathVariable String phone){
    	return repository.addUser(userName,phone);
    }
    
	/*
	 * @RequestMapping(value="/createNewUser",method = RequestMethod.POST, consumes
	 * = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces =
	 * MediaType.APPLICATION_JSON_VALUE)
	 * 
	 * @CrossOrigin(origins= {"http://localhost:3000"}) public String
	 * createUser(@RequestBody(required = false) UserTo userTo){ return
	 * repository.addUser(userTo.getName(),userTo.getPhone()); }
	 */
    
}
