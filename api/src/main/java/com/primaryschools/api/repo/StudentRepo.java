package com.primaryschools.api.repo;

import com.primaryschools.api.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, String> {
    Optional<Student> findById(String id);
}
