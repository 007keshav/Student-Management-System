package com.management.SMS.repository;

import com.management.SMS.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student ,Long> {
}
