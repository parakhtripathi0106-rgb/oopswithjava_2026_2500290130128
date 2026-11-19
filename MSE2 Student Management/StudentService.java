
package com.example.studentmanagement;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public int addStudent(Student student) {
        return repository.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }

    public Student getStudentById(int id) {
        return repository.getStudentById(id);
    }

    public int updateStudent(int id, Student student) {
        return repository.updateStudent(id, student);
    }

    public int deleteStudent(int id) {
        return repository.deleteStudent(id);
    }

    public List<Student> getMeritList() {
        return repository.getMeritList();
    }
}
