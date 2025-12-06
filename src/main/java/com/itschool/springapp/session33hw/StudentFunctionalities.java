package com.itschool.springapp.session33hw;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentFunctionalities{

    private final RepositoryforStudents repo;

    public StudentFunctionalities(RepositoryforStudents repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PostMapping
    public Student create(@RequestBody Student s) {
        return repo.save(s);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s) {
        Student existing = repo.findById(id).orElseThrow();
        existing.setName(s.getName());
        existing.setAge(s.getAge());
        existing.setEmail(s.getEmail());
        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @GetMapping("/search/name/{name}")
    public List<Student> findByName(@PathVariable String name) {
        return repo.findByName(name);
    }

    @GetMapping("/search/email/{keyword}")
    public List<Student> searchByEmail(@PathVariable String keyword) {
        return repo.findByEmailContaining(keyword);
    }
}
