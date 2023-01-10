package com.syd.evaluation.api.controller;

import com.syd.evaluation.persistence.entity.EvaluationLevel;
import com.syd.evaluation.persistence.repository.EvaluationLevelRepository;
import com.syd.evaluation.util.annotation.PreAuthorizeAdminOrDepsAdmin;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * ignore service layer cuz it's so easy
 * if it needed we can create/add service layer
 */


@RestController
@RequiredArgsConstructor
@RequestMapping("evaluation-level")
public class EvaluationLevelController {

    private final EvaluationLevelRepository evaluationLevelRepository;

    @GetMapping
    @PreAuthorizeAdminOrDepsAdmin
    public Iterable<EvaluationLevel> getAll() {
        return evaluationLevelRepository.findAll();
    }

    @PostMapping
    @PreAuthorizeAdminOrDepsAdmin
    public EvaluationLevel add(@RequestBody EvaluationLevel evaluationLevel) {
        return evaluationLevelRepository.save(evaluationLevel);
    }


    @PatchMapping
    @PreAuthorizeAdminOrDepsAdmin
    public void update(@RequestBody EvaluationLevel evaluationLevel) {
        evaluationLevelRepository.findById(evaluationLevel.getId()).ifPresent(el -> {
            el.setActive(evaluationLevel.getActive());
            el.setName(evaluationLevel.getName());
            evaluationLevelRepository.save(el);
        });
    }

    @DeleteMapping("{id}")
    @PreAuthorizeAdminOrDepsAdmin
    public void delete(@PathVariable Long id) {
        evaluationLevelRepository.deleteById(id);
    }


}
