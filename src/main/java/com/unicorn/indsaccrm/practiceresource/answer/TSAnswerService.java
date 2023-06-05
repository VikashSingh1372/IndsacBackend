package com.unicorn.indsaccrm.practiceresource.answer;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TSAnswerService {
    ResponseEntity<?> saveanswer(TSAnswer requestanswer);

    ResponseEntity<List<TSAnswer>> getAllTSAnswer();

    ResponseEntity<Optional<TSAnswer>> getByTSAnswer(UUID id);

}

