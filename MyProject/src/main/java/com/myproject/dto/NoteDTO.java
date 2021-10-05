package com.myproject.dto;

import lombok.Data;

@Data
public class NoteDTO {
	private Long id;
	private Long parentid;
	private String content;
	private String username;
}
