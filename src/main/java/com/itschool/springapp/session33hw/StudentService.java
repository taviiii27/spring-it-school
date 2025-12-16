package com.itschool.springapp.session33hw;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Student create(Student s) {
        return repo.save(s);
    }

    public Student update(Long id, Student s) {
        Student existing = repo.findById(id).orElseThrow();
        existing.setName(s.getName());
        existing.setAge(s.getAge());
        existing.setEmail(s.getEmail());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Student> findByName(String name) {
        return repo.findByName(name);
    }

    public List<Student> searchByEmail(String keyword) {
        return repo.findByEmailContaining(keyword);
    }
}
