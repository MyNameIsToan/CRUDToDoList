package com.myproject.service;

import java.util.List;

import com.myproject.dto.NoteDTO;

public interface INoteService {
	List<NoteDTO> GetAll();
	void Save(NoteDTO note);
	void Update(NoteDTO note);
	void Delete(Long id);
}
