package com.surpass.exercise;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExerciseService {

    Page<Exercise> getAllExercises(Pageable page);

    Exercise getExerciseById(Long id);

    void deleteExerciseById(Long id);

    long getExercisesCount();

    Exercise addExercise(Exercise exercise);

    Exercise updateExercise(Long id, Exercise exercise);

}
