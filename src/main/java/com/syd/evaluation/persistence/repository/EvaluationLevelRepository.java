package com.syd.evaluation.persistence.repository;

import com.syd.evaluation.persistence.entity.EvaluationLevel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationLevelRepository extends CrudRepository<EvaluationLevel, Long> {
}
