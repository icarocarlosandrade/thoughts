package com.futago.thoughts.rest.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NoteDTO {

	private Long id;
	private String title;
	private String description;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private boolean archived;
	private boolean deleted;
}