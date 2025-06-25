package com.vopa.Assignment.Feature.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vopa.Assignment.Feature.dto.AssignmentRequest;
import com.vopa.Assignment.Feature.dto.AssignmentResponse;
import com.vopa.Assignment.Feature.service.AssignmentService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    /** 1️⃣ POST /api/assignments */
    @PostMapping("/assignments")
    public ResponseEntity<AssignmentResponse> assignLesson(
            @RequestBody AssignmentRequest request) {
        AssignmentResponse resp = assignmentService.assignLesson(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @GetMapping("/students/{studentId}/assignments")
    public List<AssignmentResponse> getStudentAssignments(
            @PathVariable String studentId,
            @RequestParam(defaultValue = "pending") String status) {
        return assignmentService.findByStudentAndStatus(studentId, status);
    }

    @PatchMapping("/students/{assignmentId}/complete")
    public AssignmentResponse completeAssignment(@PathVariable String assignmentId) {
        return assignmentService.markCompleted(assignmentId);
    }

    @GetMapping("/teachers/{teacherId}/assignments")
    public List<AssignmentResponse> getTeacherAssignments(@PathVariable String teacherId) {
        return assignmentService.findByTeacher(teacherId);
    }
}
