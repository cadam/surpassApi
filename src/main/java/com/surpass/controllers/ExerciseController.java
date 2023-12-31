package com.surpass.controllers;

import com.surpass.entities.Exercise;
import com.surpass.services.ExerciseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/exercises")
    public List<Exercise> getAllExercises(Pageable page) {
        return exerciseService.getAllExercises(page).toList();
    }

    @GetMapping("/exercises/{id}")
    public Exercise getExerciseById(@PathVariable Long id) {
        return exerciseService.getExerciseById(id);
    }

    @GetMapping("/exercises/count")
    public long getExercisesCount() {
        return exerciseService.getExercisesCount();
    }

//    delete exercise by id
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/exercises/{id}")
    public void deleteExerciseById(@PathVariable Long id) {
        exerciseService.deleteExerciseById(id);
    }

//    post exercise
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/exercises/add")
    public Exercise addExercise(@Valid @RequestBody Exercise exercise) {

        return exerciseService.addExercise(exercise);

    }

//    put exercise
    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping("/exercises/{id}")
    public Exercise updateExercise(@RequestBody Exercise exercise,
                           @PathVariable Long id) {

        return exerciseService.updateExercise(id, exercise);

    }
}
