package com.example.CRUD_STUDENT_FORM.service;

import com.example.CRUD_STUDENT_FORM.model.Student_Details;
import com.example.CRUD_STUDENT_FORM.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService
{
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //create
    public void create(Student_Details student_details)
    {
        studentRepository.save(student_details);
    }

    //read
    public List<Student_Details> read()
    {
        return studentRepository.findAll();
    }

    //delete
    public void delete(long id)
    {
        studentRepository.deleteById(id);
    }

    //order by id
    public Student_Details getStudentsById(long id)
    {
        return studentRepository.findById(id).orElseThrow();
    }
}
