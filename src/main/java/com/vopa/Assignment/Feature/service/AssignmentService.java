package com.vopa.Assignment.Feature.service;

import com.vopa.Assignment.Feature.dto.AssignmentRequest;
import com.vopa.Assignment.Feature.dto.AssignmentResponse;
import com.vopa.Assignment.Feature.entity.Assignment;
import com.vopa.Assignment.Feature.repository.AssignmentRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;

@Service
@RequiredArgsConstructor
@Transactional
public class AssignmentService {

    private final AssignmentRepository assignmentRepo;
    private final ModelMapper mapper = new ModelMapper(); // or MapStruct

    public AssignmentResponse assignLesson(AssignmentRequest request) {
        Assignment assignment = new Assignment();
        assignment.setTeacherId(request.getTeacherId());
        assignment.setStudentId(request.getStudentId());
        assignment.setLessonId(request.getLessonId());
        assignment.setStatus("pending");
        assignment.setAssignedOn(LocalDate.now());

        assignmentRepo.save(assignment);

        AssignmentResponse response = new AssignmentResponse();
        response.setAssignmentId(assignment.getAssignmentId());
        response.setMessage("Lesson assigned successfully");
        response.setStatus("pending");

        return response;
    }


    public List<AssignmentResponse> findByStudentAndStatus(String studentId, String status) {
        return assignmentRepo.findByStudentIdAndStatus(studentId, status).stream()
                .map(a -> mapper.map(a, AssignmentResponse.class))
                .toList();
    }

    public AssignmentResponse markCompleted(String assignmentId) {
        Assignment a = assignmentRepo.findById(assignmentId)
                .orElseThrow(() -> new EntityNotFoundException("Assignment not found"));
        a.setStatus("completed");
        assignmentRepo.save(a);
        return mapper.map(a, AssignmentResponse.class);
    }

    public List<AssignmentResponse> findByTeacher(String teacherId) {
        return assignmentRepo.findByTeacherId(teacherId).stream()
                .map(a -> mapper.map(a, AssignmentResponse.class))
                .toList();
    }
}