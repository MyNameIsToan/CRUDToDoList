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

import com.myproject.dto.NoteDTO;
import com.myproject.service.INoteService;

@RestController
public class NoteAPI {
	@Autowired
	private INoteService noteService;
	
	@GetMapping(value="/Note")
	public List<NoteDTO> GetAll(){
		return noteService.GetAll();
	}
	
	@PostMapping(value="/Note")
	public void Save(@RequestBody NoteDTO model) {
		noteService.Save(model);
	}
	
	@PutMapping(value="/Note")
	public void Update(@RequestBody NoteDTO model) {
		noteService.Update(model);
	}
	
	@DeleteMapping(value="/Note/{id}")
	public void Delete(@PathVariable("id") Long id) {
		noteService.Delete(id);
	}
}
