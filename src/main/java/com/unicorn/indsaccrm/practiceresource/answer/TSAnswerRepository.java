package com.unicorn.indsaccrm.practiceresource.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface TSAnswerRepository extends JpaRepository<TSAnswer, UUID> {
}
