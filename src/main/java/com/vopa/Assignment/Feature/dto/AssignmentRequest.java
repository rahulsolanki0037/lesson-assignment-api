package com.vopa.Assignment.Feature.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AssignmentRequest {
    @JsonProperty("teacher_id")
    private String teacherId;

    @JsonProperty("student_id")
    private String studentId;

    @JsonProperty("lesson_id")
    private String lessonId;
}
