package com.futago.thoughts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futago.thoughts.entity.Note;
import com.futago.thoughts.repository.NoteRepository;

@Service
public class NoteService {

	private NoteRepository repository;

	@Autowired
	public NoteService(NoteRepository noteRepository) {
		repository = noteRepository;
	}

	public Note save(Note note) {
		note.setId(0L);
		return repository.save(note);
	}
	
	public Note update(Note note) {
		return repository.save(note);
	}

	public Note findById(Long id) {
		Optional<Note> result = repository.findById(id);

		if (result.isPresent()) {
			return result.get();
		}

		return null;
	}

	public List<Note> findAll() {
		return repository.findAll();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
