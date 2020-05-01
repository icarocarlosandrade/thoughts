package com.futago.thoughts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futago.thoughts.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
