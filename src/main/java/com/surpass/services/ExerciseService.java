package com.surpass.services;

import com.surpass.entities.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExerciseService {

    Page<Exercise> getAllExercises(Pageable page);

    Exercise getExerciseById(Long id);

    void deleteExerciseById(Long id);

    long getExercisesCount();

    Exercise addExercise(Exercise exercise);

    Exercise updateExercise(Long id, Exercise exercise);

}
