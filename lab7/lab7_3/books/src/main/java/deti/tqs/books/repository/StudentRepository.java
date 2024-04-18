package deti.tqs.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import deti.tqs.books.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {}
