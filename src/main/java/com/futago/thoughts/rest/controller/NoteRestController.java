package com.futago.thoughts.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futago.thoughts.entity.Note;
import com.futago.thoughts.rest.dto.NoteDTO;
import com.futago.thoughts.rest.dto.NoteMapper;
import com.futago.thoughts.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteRestController {

	private NoteService service;

	@Autowired
	public NoteRestController(NoteService noteService) {
		service = noteService;
	}

	@PostMapping
	public NoteDTO save(@RequestBody NoteDTO dto) {
		NoteMapper mapper = new NoteMapper();
		Note note = mapper.toEntity(dto);
		note = service.save(note);
		dto = mapper.toDTO(note);
		return dto;
	}

	@PutMapping
	public NoteDTO update(@RequestBody NoteDTO dto) {
		if (dto.getId() == null) {
			throw new RuntimeException("Id is null");
		}

		NoteMapper mapper = new NoteMapper();
		Note note = mapper.toEntity(dto);
		// Porque createdDate returna null?
		note = service.update(note);
		dto = mapper.toDTO(note);
		return dto;
	}

	@GetMapping
	public List<Note> findAll() {
		return service.findAll();
	}

	@GetMapping("{id}")
	public Note findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
