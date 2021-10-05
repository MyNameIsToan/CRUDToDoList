package com.myproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.dto.UserDTO;
import com.myproject.service.IUserService;

@RestController
public class UserAPI {
	@Autowired
	private IUserService userService;
	
	@GetMapping(value="/User")
	public List<UserDTO> GetAll() {
		return userService.GetAll();
	}
	
	@PostMapping(value="/User")
	public void Save(@RequestBody UserDTO model) {
		userService.Save(model);
	}
	
	@PutMapping(value="/User")
	public void Update(@RequestBody UserDTO model) {
		userService.Update(model);
	}
	
	@DeleteMapping(value="/User/{id}")
	public void Delete(@PathVariable("id") String Username) {
		userService.Delete(Username);
	}
}
