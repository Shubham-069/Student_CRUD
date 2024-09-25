package com.sample.studentcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sample.studentcrud.dto.StudentRequest;
import com.sample.studentcrud.dto.StudentResponse;
import com.sample.studentcrud.entities.Student;
import com.sample.studentcrud.repository.StudentRepository;
import com.sample.studentcrud.translator.StudentTranslator;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentTranslator studentTranslator;

	// to add a student
	public Student addStudent(StudentRequest request) {
//		ObjectMapper mapper = new ObjectMapper();
//		Student stu = mapper.convertValue(request, Student.class);
		Student student = studentTranslator.translateToEntity(request);
		return studentRepository.save(student);
	}

	// to find all students
	public List<Student> allStudent() {
		return studentRepository.findAll();
	}

	// to find students by id
	public StudentResponse findStudentById(Integer id) {
		Optional<Student> student = studentRepository.findById(id);
		return student.map(studentTranslator::translateToResponse).orElse(null);
	}

	// to update the student by id
	public StudentResponse updateStudent(Integer id, StudentRequest request) {
		Optional<Student> existingStudent = studentRepository.findById(id);
		if (existingStudent.isPresent()) {
			Student student = existingStudent.get();
			student.setName(request.getName());
			student.setCourse(request.getCourse());
			student.setFee(request.getFee());
			Student updatedStudent = studentRepository.save(student);
			return studentTranslator.translateToResponse(updatedStudent);
		} else {
			return null;
		}

	}

	// to delete student by id
	public void deleteStudentById(Integer id) {
		studentRepository.deleteById(id);
	}
}
