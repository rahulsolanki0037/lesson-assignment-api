package com.vopa.Assignment.Feature.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String assignmentId;

    private String teacherId;
    private String studentId;
    private String lessonId;
    private String status;
    private LocalDate assignedOn;
}
