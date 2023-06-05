package com.unicorn.indsaccrm.course;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseCardService {
    ResponseEntity<?> saveCourseCard(CourseCard request);

    ResponseEntity<List<CourseCard>> getAllCourseCards();

    ResponseEntity<Optional<CourseCard>> getByCourseId(UUID id);

    void uploadCourseCardImage(MultipartFile file,UUID courseCardId);
}
