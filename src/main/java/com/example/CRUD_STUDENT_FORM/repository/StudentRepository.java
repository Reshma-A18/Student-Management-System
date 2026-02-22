package com.example.CRUD_STUDENT_FORM.repository;

import com.example.CRUD_STUDENT_FORM.model.Student_Details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student_Details,Long>
{

}