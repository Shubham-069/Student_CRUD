package com.sample.studentcrud.translator;

import org.springframework.stereotype.Component;

import com.sample.studentcrud.dto.StudentRequest;
import com.sample.studentcrud.dto.StudentResponse;
import com.sample.studentcrud.entities.Student;

@Component
public class StudentTranslator {
	
	public Student translateToEntity(StudentRequest request) {
		Student student =new Student();
		student.setName(request.getName());
		student.setCourse(request.getCourse());
		student.setFee(request.getFee());
		return student;
	}
	
	public StudentResponse translateToResponse(Student student) {
		StudentResponse response=new StudentResponse();
		response.setId(student.getId());
		response.setName(student.getName());
		response.setCourse(student.getCourse());
		response.setFee(student.getFee());
		return response;
	}

}
