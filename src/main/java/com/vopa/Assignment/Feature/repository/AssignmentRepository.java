package com.vopa.Assignment.Feature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vopa.Assignment.Feature.entity.Assignment;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, String> {
    List<Assignment> findByStudentIdAndStatus(String studentId, String status);
    List<Assignment> findByTeacherId(String teacherId);
}
