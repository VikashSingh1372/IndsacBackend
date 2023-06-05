package com.unicorn.indsaccrm.course;

import com.unicorn.indsaccrm.util.storage.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseCardServiceImpl implements CourseCardService{
    Logger logger = LoggerFactory.getLogger(CourseCardServiceImpl.class);
    @Autowired
    CourseCardRepository courseCardRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public ResponseEntity<?> saveCourseCard(CourseCard request) {
        logger.info("CourseCard Saved Successfully");
        return  new ResponseEntity<>(courseCardRepository.save(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CourseCard>> getAllCourseCards() {
        logger.info("Get ALL CourseCard Successfully");
        return  ResponseEntity.ok(courseCardRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<CourseCard>> getByCourseId(UUID id) {
        logger.info("Get ALL CourseCard Successfully");
        return   ResponseEntity.ok(courseCardRepository.findById(id));
    }

    @Override
    public void uploadCourseCardImage(MultipartFile file,UUID courseCardId) {
        String fileName = fileStorageService.storeFile(file);
        Optional<CourseCard> courseCard=courseCardRepository.findById(courseCardId);
        if(courseCard!=null){
            courseCard.get().setImage(fileName);
            courseCardRepository.save(courseCard.get());
        }
    }
}
