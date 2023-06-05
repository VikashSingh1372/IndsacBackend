package com.unicorn.indsaccrm.practiceresource.tsquestion;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TSQuestionService {
    ResponseEntity<?> saveService(TSQuestion request);
    ResponseEntity<List<TSQuestion>> getAllTSQuestion();

    ResponseEntity<Optional<TSQuestion>> getByTSQuestion(UUID id);

}