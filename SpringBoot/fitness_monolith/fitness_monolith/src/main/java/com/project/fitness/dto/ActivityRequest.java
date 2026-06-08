package com.project.fitness.dto;

import com.project.fitness.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
public class ActivityRequest {
    private ActivityType type;
    private String userId;
    private Map<String,Object> additionalMetrics;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
}
