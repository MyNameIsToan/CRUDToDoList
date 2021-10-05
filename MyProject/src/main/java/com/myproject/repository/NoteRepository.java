package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.entity.NoteEntity;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

}
