package com.myproject.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dto.UserDTO;
import com.myproject.entity.UserEntity;
import com.myproject.repository.UserRepository;
import com.myproject.service.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserDTO> GetAll() {
		List<UserDTO> ListOfUserDTO = new ArrayList<>();
		List<UserEntity> ListOfUserEntity = userRepository.findAll();
		for(UserEntity item : ListOfUserEntity) {
			UserDTO userDTO = new UserDTO();
			userDTO.setUsername(item.getUsername());
			userDTO.setPassword(item.getPassword());
			userDTO.setFirstname(item.getFirstname());
			userDTO.setLastname(item.getLastname());
			userDTO.setEmail(item.getEmail());
			ListOfUserDTO.add(userDTO);
		}
		return ListOfUserDTO;
	}

	@Override
	public void Save(UserDTO user) {
		UserEntity userentity = new UserEntity();
		userentity.setUsername(user.getUsername());
		userentity.setPassword(user.getPassword());
		userentity.setEmail(user.getEmail());
		userentity.setFirstname(user.getFirstname());
		userentity.setLastname(user.getLastname());
		userRepository.save(userentity);
	}

	@Override
	public void Update(UserDTO user) {
		UserEntity userentity = userRepository.findOne(user.getUsername());
		userentity.setPassword(user.getPassword());
		userentity.setEmail(user.getEmail());
		userentity.setFirstname(user.getFirstname());
		userentity.setLastname(user.getLastname());
		userRepository.save(userentity);
	}

	@Override
	public void Delete(String Username) {
		UserEntity userentity = userRepository.findOne(Username);
		if(userentity != null) {
			userRepository.delete(Username);
		}
	}

}
