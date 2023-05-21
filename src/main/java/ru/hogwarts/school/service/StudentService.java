package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;

@Service
public class StudentService {

    private long counterId = 0;
    private final Map<Long, Student> students = new HashMap<>();

    public Student add(Student student) {
        student.setId(++counterId);
        students.put(student.getId(), student);
        return student;
    }

    public Optional<Student> update(Long id, Student student) {
        if (students.containsKey(id)) {
            students.replace(id, student);
            return Optional.of(student);
        }
        return Optional.empty();
    }

    public Optional<Student> getById(Long id) {
        return Optional.ofNullable(students.get(id));
    }

    public Collection<Student> getAll() {
        return Collections.unmodifiableCollection(students.values());
    }

    public Optional<Student> deleteById(Long id) {
        return Optional.ofNullable(students.remove(id));
    }

}
