package com.sample.studentcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.studentcrud.dto.StudentRequest;
import com.sample.studentcrud.dto.StudentResponse;
import com.sample.studentcrud.entities.Student;
import com.sample.studentcrud.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// to add a student
	@PostMapping("/save")
	public ResponseEntity<Student> save(@RequestBody StudentRequest stu) {
		Student student = studentService.addStudent(stu);
		return ResponseEntity.ok(student);
	}

	// to get all students
	@GetMapping("/getAll")
	public List<Student> findAllStudent() {
		return studentService.allStudent();
	}

	// to get students by id
	@GetMapping("/{id}")
	public ResponseEntity<StudentResponse> findStudentById(@PathVariable("id") Integer id) {
		StudentResponse response = studentService.findStudentById(id);
		return ResponseEntity.ok(response);

	}

	// to update student
	@PutMapping("/{id}")
	public ResponseEntity<StudentResponse> updateStudent(@PathVariable("id") Integer id,
			@RequestBody StudentRequest request) {
		StudentResponse response = studentService.updateStudent(id, request);
		if (response != null) {
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// to delete student by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudentById(@PathVariable("id") Integer id) {
		studentService.deleteStudentById(id);
		return ResponseEntity.noContent().build();
	}

}
