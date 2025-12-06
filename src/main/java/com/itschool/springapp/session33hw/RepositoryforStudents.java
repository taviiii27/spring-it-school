package com.itschool.springapp.session33hw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryforStudents extends JpaRepository<Student, Long> {

    List<Student> findByName(String name);

    List<Student> findByAgeGreaterThan(int age);

    List<Student> findByEmailContaining(String keyword);

    List<Student> findAllByOrderByAgeAsc();

    List<Student> findByNameStartingWith(String prefix);
}
