package com.unicorn.indsaccrm.practiceresource.category;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuestionSeriesCategoryService {
    ResponseEntity<?> savequecate(QuestionSeriesCategory requestque);
    ResponseEntity<List<QuestionSeriesCategory>>getAllQuestionSeries();
  ResponseEntity<Optional<QuestionSeriesCategory>> getByQuestionSeriesId(UUID id);
}
