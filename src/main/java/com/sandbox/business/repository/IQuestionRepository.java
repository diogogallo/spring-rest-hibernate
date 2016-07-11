package com.sandbox.business.repository;

import com.sandbox.business.domain.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by diogogallo on 7/11/16.
 */
public interface IQuestionRepository extends JpaRepository<Question, Long> {

    }
