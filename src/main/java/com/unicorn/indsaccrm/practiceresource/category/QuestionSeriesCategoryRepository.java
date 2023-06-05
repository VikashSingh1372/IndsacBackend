package com.unicorn.indsaccrm.practiceresource.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface QuestionSeriesCategoryRepository extends JpaRepository<QuestionSeriesCategory, UUID> {
}
