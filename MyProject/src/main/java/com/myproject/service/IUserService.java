package com.myproject.service;

import java.util.List;

import com.myproject.dto.UserDTO;

public interface IUserService {
	List<UserDTO> GetAll();
	void Save(UserDTO user);
	void Update(UserDTO user);
	void Delete(String Username);
}
