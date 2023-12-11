package com.surpass.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepo;

//    gets

    @Override
    public List<Exercise> getAllExercises() {

        return exerciseRepo.findAll();

    }

    @Override
    public long getExercisesCount() {

        return exerciseRepo.count();

    }

    @Override
    public Exercise getExerciseById(Long id) {

        Optional<Exercise> exercise = exerciseRepo.findById(id);

        if (exercise.isPresent()) {
            return exercise.get();
        }

        throw new RuntimeException("Exercise is not found for the id " + id);

    }

//    delete

    @Override
    public void deleteExerciseById(Long id) {

        exerciseRepo.deleteById(id);

    }

//    posts
    @Override
    public Exercise addExercise(Exercise exercise) {

        return exerciseRepo.save(exercise);

    }

//    updates

    @Override
    public Exercise updateExercise(Long id, Exercise exercise) {

        Exercise existingExercise = getExerciseById(id);

        existingExercise.setStringId(exercise.getStringId() != null ? exercise.getStringId() : existingExercise.getStringId());
        existingExercise.setBodyPart(exercise.getBodyPart() != null ? exercise.getBodyPart() : existingExercise.getBodyPart());
        existingExercise.setWeightConnection(exercise.getWeightConnection() != null ? exercise.getWeightConnection() : existingExercise.getWeightConnection());
        existingExercise.setType(exercise.getType() != null ? exercise.getType() : existingExercise.getType());
        existingExercise.setName(exercise.getName() != null ? exercise.getName() : existingExercise.getName());

        return exerciseRepo.save(existingExercise);
    }
}
