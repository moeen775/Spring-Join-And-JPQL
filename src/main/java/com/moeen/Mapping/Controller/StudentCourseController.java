package com.moeen.Mapping.Controller;

import com.moeen.Mapping.Entity.Student;
import com.moeen.Mapping.Repository.CourseRepository;
import com.moeen.Mapping.Repository.StudentRepository;
import com.moeen.Mapping.dto.StudentCourseFind;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentCourseController {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }
    @PostMapping("/saveStudentWithCourse")
    public Student saveStudentWithCourse(@RequestBody Student  student)
    {
        return studentRepository.save(student);
    }
    @GetMapping("/allStudent")
    public List<Student> getAllStudent()
    {
        return studentRepository.getAllStudent();
    }
    @GetMapping("/name1/{name}")
    public Student getStudentByName(@PathVariable String name)
    {
        return studentRepository.getStudentByName(name);
    }
    @GetMapping("/cusStudent")
    public List<StudentCourseFind> getAllStudentCus()
    {
        return studentRepository.customJoinGet();
    }
    @GetMapping("/cusStudent1/{name}")
    public List<StudentCourseFind> getAllStudentCus1(@PathVariable("name") String name)
    {
        return studentRepository.customJoinGetNameFilter(name);
    }
    @GetMapping("/java/{name}")
    public ResponseEntity<StudentCourseFind>getAllStudentCusWithTitle(@PathVariable("name") String name)
    {
        return new ResponseEntity<StudentCourseFind>(studentRepository.customJoinGetNameFilterWithTitle(name),HttpStatus.OK);
    }
}
