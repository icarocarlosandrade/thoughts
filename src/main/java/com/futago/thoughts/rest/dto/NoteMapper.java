package com.futago.thoughts.rest.dto;

import org.springframework.beans.BeanUtils;

import com.futago.thoughts.entity.Note;

public class NoteMapper {

	public NoteDTO toDTO(Note note) {
		NoteDTO dto = new NoteDTO();
		BeanUtils.copyProperties(note, dto);
		return dto;
	}

	public Note toEntity(NoteDTO dto) {
		Note note = new Note();
		BeanUtils.copyProperties(dto, note);
		return note;
	}
}
