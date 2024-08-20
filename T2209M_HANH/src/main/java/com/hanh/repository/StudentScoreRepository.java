package com.hanh.repository;

import com.hanh.entities.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentScoreRepository extends JpaRepository<StudentScore, Integer> {
}

