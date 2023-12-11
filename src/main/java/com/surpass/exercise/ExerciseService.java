package com.surpass.exercise;

import java.util.List;

public interface ExerciseService {

    List<Exercise> getAllExercises();

    Exercise getExerciseById(Long id);

    void deleteExerciseById(Long id);

    long getExercisesCount();

    Exercise addExercise(Exercise exercise);

    Exercise updateExercise(Long id, Exercise exercise);

}
