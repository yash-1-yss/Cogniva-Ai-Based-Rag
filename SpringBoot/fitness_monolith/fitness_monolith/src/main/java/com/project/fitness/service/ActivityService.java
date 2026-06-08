package com.project.fitness.service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {
    @Autowired
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public  List<ActivityResponse> getActivity(String userId) {
        List<Activity> activityList=activityRepository.findByUserId(userId);
        return activityList.stream()
                .map(this::mapToReturn).toList();
    }

    public ActivityResponse trackActivity(ActivityRequest activityRequest) {
        User user=userRepository.findById(activityRequest.getUserId()).
                orElseThrow(()-> new RuntimeException("User not defined"));
        Activity activity=Activity.builder()
                .user(user)
                .type(activityRequest.getType())
                .additionalMetrics(activityRequest.getAdditionalMetrics())
                .duration(activityRequest.getDuration())
                .caloriesBurned(activityRequest.getCaloriesBurned())
                .startTime(activityRequest.getStartTime())
                .build();
        Activity savedActivity = activityRepository.save(activity);
        return mapToReturn(savedActivity);
    }

    private ActivityResponse mapToReturn(Activity savedActivity) {
        ActivityResponse response=new ActivityResponse();
        response.setId(savedActivity.getId());
        response.setType(savedActivity.getType());
        response.setDuration(savedActivity.getDuration());
        response.setAdditionalMetrics(savedActivity.getAdditionalMetrics());
        response.setStartTime(savedActivity.getStartTime());
        response.setCreatedAt(savedActivity.getCreatedAt());
        response.setCaloriesBurned(savedActivity.getCaloriesBurned());
        response.setUserId(savedActivity.getUser().getId());
        response.setUpdatedAt(savedActivity.getUpdatedAt());
        return response;
    }
}
