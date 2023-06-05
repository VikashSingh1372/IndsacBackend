package com.unicorn.indsaccrm.practiceresource.category;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TestSeriesCategoryService {
    ResponseEntity<?>savecategory(TestSeriesCategory testSeriesCategory);
    ResponseEntity<List<TestSeriesCategory>>getAllTestSeries();
    ResponseEntity<Optional<TestSeriesCategory>> getByTestSeriesId(UUID id);


}
