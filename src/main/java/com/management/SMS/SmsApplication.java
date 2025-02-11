package com.management.SMS;

import com.management.SMS.entity.Student;
import com.management.SMS.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
//		Student student1  = new Student("keshav","krishn","7482909072","keshavkrishn1006@gmail.com");
//		studentRepository.save(student1);
//		Student student2  = new Student("prakhar","shukla","95897566","prakahre454324@gmail.com");
//		studentRepository.save(student2);
//		Student student3 = new Student("sukriti","vats","895566626","sukritivats@gmail.com");
//		studentRepository.save(student3);
//		Student student4 = new Student("richik","pandit","895566626","richikpandit@gmail.com");
//		studentRepository.save(student4);

	}
}
