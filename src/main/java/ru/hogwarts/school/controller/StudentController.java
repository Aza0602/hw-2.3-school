package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @GetMapping
    public Collection<Student> getAll() {
        return studentService.getAll();
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentService.add(student);
    }

    @PutMapping("/{id}")
    public Optional<Student> update(@PathVariable Long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public Optional<Student> deleteById(@PathVariable Long id) {
        return studentService.deleteById(id);
    }

}
