package com.myproject.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
}
