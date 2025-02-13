package com.management.SMS.service.impl;

import com.management.SMS.entity.Student;
import com.management.SMS.exception.ResourceNotFoundException;
import com.management.SMS.exception.StudentNotFoundException;
import com.management.SMS.repository.StudentRepository;
import com.management.SMS.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> getAllStudent() {
        List<Student> students =  studentRepository.findAll();
        System.out.println("Students from DB: " + students);
        return students;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with "+ id + "not found"));
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student with ID " + id + " not found.");
        }
        studentRepository.deleteById(id);
    }


}
