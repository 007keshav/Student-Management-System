package com.management.SMS.controller;

import com.management.SMS.entity.Student;
import com.management.SMS.exception.StudentNotFoundException;
import org.springframework.ui.Model;
import com.management.SMS.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    //handler method for handling list of students and return mode and view

    @GetMapping("/students")
    public String listStudents(Model model){
//        model.addAttribute("students", studentService.getAllStudent());
//        return "students";
        List<Student> students = studentService.getAllStudent();

        // Debugging: Print students in console
        System.out.println("Fetched Students: " + students);

        model.addAttribute("students", students);
        return "students";

    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        //create student objects
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String getStudentById(@PathVariable Long id, Model model) {
        try {
            Student student = studentService.getStudentById(id);
            model.addAttribute("student", student);
            return "student-detail"; // Name of the HTML page
        } catch (StudentNotFoundException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error/student-not-found"; // Custom error page
        }
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }


    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model){
        //get student id  from database
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setPhone(student.getPhone());
        existingStudent.setEmail(student.getEmail());

        //save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    //handler method to delete student object
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudentById(id); 
            return "redirect:/students"; 
        } catch (StudentNotFoundException e) {
        
            return "error/student-not-found"; 
        } catch (Exception e) {
            return "error/general-error"; 
        }
    }


}
