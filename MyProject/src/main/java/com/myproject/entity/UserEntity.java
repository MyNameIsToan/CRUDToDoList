package com.myproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="users")
@Data
public class UserEntity {
	@Id
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<NoteEntity> ListOfNote;
}
