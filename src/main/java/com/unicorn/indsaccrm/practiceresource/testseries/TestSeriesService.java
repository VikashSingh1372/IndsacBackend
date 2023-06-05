package com.unicorn.indsaccrm.practiceresource.testseries;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TestSeriesService {
    ResponseEntity<?>savetest(TestSeries testrequest);
    ResponseEntity<List<TestSeries>>getAllTestSeries();
    ResponseEntity<Optional<TestSeries>>getByTestSeriesId(UUID Id);
}
