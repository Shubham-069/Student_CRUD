package com.sample.studentcrud.dto;

import lombok.Data;

@Data
public class StudentResponse {
	private Integer id;
	private String name;
	private String course;
	private String fee;
}
