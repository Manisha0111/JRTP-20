package com.example.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.model.Student;
import com.example.repo.StudentRepository;

@Component
public class StudentTestRunner implements CommandLineRunner {
	@Autowired
	private StudentRepository repo;

	@Override
	public void run(String... args) throws Exception {

		repo.save(new Student(10, "A", 3.3));
		repo.save(new Student(11, "B", 4.8));
		repo.save(new Student(12, "C", 5.9));
		repo.saveAll(Arrays.asList(new Student(13, "C", 5.9),new Student(15, "C", 5.9)));

		repo.saveAll(Arrays.asList(new Student(13, "D", 4.5), new Student(14, "E", 9.5), new Student(15, "F", 8.5)));

		
		//==============
		System.out.println("------------------------------------");
		//----------------------------------//
		boolean exist=repo.existsById(13);
		System.out.println(exist);
		
		System.out.println("++++++++++++++++++++++++++++++");
		//------------Read one object and print-----
		Optional<Student>  opt=repo.findById(13);
		if(opt.isPresent()) {
			Student s=opt.get();
			System.out.println(s);
		}
		
		System.out.println("------------------------");
		repo.findAll().forEach(System.out::println);
		
		System.out.println("**********************");
	List<Student> stdList	=(List<Student>) repo.findAllById(Arrays.asList(10,15,14));
		//.forEach(System.out::println);
	int i=0;
	for (Student student : stdList) {
		
		System.out.println("In Side For="+ ++i);
		if(student.getStdId()==15) {
		System.out.println(student.getStdId()+" "+student.getStdName()+" "+student.getStdFee());
		}
	}
		
		
		
	}

}
