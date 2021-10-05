package com.myproject.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.dto.NoteDTO;
import com.myproject.entity.NoteEntity;
import com.myproject.entity.UserEntity;
import com.myproject.repository.NoteRepository;
import com.myproject.repository.UserRepository;
import com.myproject.service.INoteService;

@Service
public class NoteService implements INoteService{
	
	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private UserRepository userRepository;
	@Override
	public List<NoteDTO> GetAll() {
		List<NoteDTO> ListOfNoteDTO = new ArrayList<>();
		List<NoteEntity> ListOfNoteEntity = noteRepository.findAll();
		for(NoteEntity item : ListOfNoteEntity) {
			NoteDTO noteDTO = new NoteDTO();
			noteDTO.setId(item.getId());
			noteDTO.setParentid(item.getParentId());
			noteDTO.setContent(item.getContent());
			noteDTO.setUsername(item.getUsers().getUsername());
			ListOfNoteDTO.add(noteDTO);
		}
		return ListOfNoteDTO;
	}

	@Override
	public void Save(NoteDTO note) {
		NoteEntity noteEntity = new NoteEntity();
		if(note.getParentid() == null) {
			noteEntity.setParentId(0L);
		}else{
			NoteEntity subNoteEntity = noteRepository.findOne(note.getParentid());
			if(subNoteEntity == null) {
				noteEntity.setParentId(0L);
			}else {
				noteEntity.setParentId(note.getParentid());
			}
		}
		noteEntity.setContent(note.getContent());
		UserEntity user = userRepository.findOne(note.getUsername());
		noteEntity.setUsers(user);
		noteRepository.save(noteEntity);
	}

	@Override
	public void Update(NoteDTO note) {
		NoteEntity noteEntity = noteRepository.findOne(note.getId());
		noteEntity.setContent(note.getContent());
		UserEntity user = userRepository.findOne(note.getUsername());
		noteEntity.setUsers(user);
		noteRepository.save(noteEntity);
	}

	@Override
	public void Delete(Long id) {
		NoteEntity noteEntity = noteRepository.findOne(id);
		if(noteEntity != null) {
			noteRepository.delete(id);
		}
	}
	
}
