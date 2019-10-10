package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDAO;
import com.model.UserDetails;

@RestController
public class HomeController {
	@Autowired
	UserDAO userdaoimpl;
	@GetMapping("/")
	public String getHome()
	{
	
		return "Home";
	}
  @PostMapping("/login")
  public ResponseEntity<?>login(@RequestBody UserDetails user)
  {
	 boolean result= userdaoimpl.getUser(user.getEmail(),user.getPassword());
	  if(result)
	  {
	  return new ResponseEntity<UserDetails>(user,HttpStatus.OK);
	  }
	  else
	  {
		  return new ResponseEntity<String>("invalid user",HttpStatus.FORBIDDEN);
	  }
  }
}
