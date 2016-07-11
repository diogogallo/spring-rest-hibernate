package com.sandbox.business.repository;

import com.sandbox.business.domain.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by diogogallo on 7/11/16.
 */
public interface ITopicRepository extends JpaRepository<Topic, Long> {

    }
