package com.itschool.springapp.session33hw;

import com.itschool.springapp.session33hw.Student;
import com.itschool.springapp.session33hw.RepositoryforStudents;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplicationForStudents {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplicationForStudents.class, args);
    }

    @Bean
    CommandLineRunner run(RepositoryforStudents repo) {
        return args -> {

            System.out.println("=== INSERT ===");
            Student s1 = repo.save(new Student("Alice", 20, "alice@example.com"));
            Student s2 = repo.save(new Student("Bob", 22, "bob@example.com"));
            Student s3 = repo.save(new Student("Charlie", 19, "charlie@example.com"));

            System.out.println("=== RETRIEVE ALL ===");
            repo.findAll().forEach(System.out::println);

            System.out.println("=== UPDATE ===");
            s1.setAge(21);
            repo.save(s1);

            System.out.println("Updated Alice: " + repo.findById(s1.getId()));

            System.out.println("=== DELETE ===");
            repo.delete(s2);

            System.out.println("Remaining: " + repo.findAll());
            System.out.println("\n=== QUERY METHODS ===");
            System.out.println("Find by name: " + repo.findByName("Alice"));
            System.out.println("Age > 20: " + repo.findByAgeGreaterThan(20));
            System.out.println("Email contains 'example': " + repo.findByEmailContaining("example"));
            System.out.println("Sort by age: " + repo.findAllByOrderByAgeAsc());
            System.out.println("Name starts with 'C': " + repo.findByNameStartingWith("C"));
        };
    }
}

