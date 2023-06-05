package com.unicorn.indsaccrm.practiceresource.tsquestion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface TSQuestionRepository extends JpaRepository<TSQuestion, UUID> {
}
