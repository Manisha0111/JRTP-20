package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
