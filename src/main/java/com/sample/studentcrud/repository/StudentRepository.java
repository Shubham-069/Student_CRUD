package com.sample.studentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.studentcrud.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer > {

}