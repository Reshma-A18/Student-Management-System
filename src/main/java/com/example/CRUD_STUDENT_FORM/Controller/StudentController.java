package com.example.CRUD_STUDENT_FORM.Controller;

import com.example.CRUD_STUDENT_FORM.model.Student_Details;
import com.example.CRUD_STUDENT_FORM.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController
{
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/add")
    public String studentForm(Model model)
    {
        model.addAttribute("student_obj", new Student_Details());
        return "Students_Form";
    }

    @PostMapping("/stud")
    public String createData(@ModelAttribute Student_Details student_details,Model model)
    {
        studentService.create(student_details);
        model.addAttribute("students",studentService.read());
        return "Students_Details";
    }

    @GetMapping
    public String studentDetails(Model model)
    {
        model.addAttribute("students",studentService.read());
        return "Students_Details";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable long id, Model model) {
        studentService.delete(id);
        model.addAttribute("students", studentService.read());
        return "Students_Details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id,Model model)
    {
        Student_Details student_details=studentService.getStudentsById(id);
        model.addAttribute("student_obj",student_details);
        return "Students_Form";
    }
}
