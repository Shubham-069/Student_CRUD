package com.sample.studentcrud.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentRequest implements Serializable{
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private String name;
	private String course;
	private String fee;
	
}
