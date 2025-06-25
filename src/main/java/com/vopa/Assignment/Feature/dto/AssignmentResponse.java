package com.vopa.Assignment.Feature.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL) 
public class AssignmentResponse {
    private String assignmentId;
    private String message;
    private String status;
    private String studentId;
    private String teacherId;
    private String lessonId;
    private String lessonTitle;
    private LocalDate assignedOn;
}
