package com.unicorn.indsaccrm.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseCardController {
    @Autowired
    CourseCardService courseCardService;



    @PostMapping
    public ResponseEntity<?> saveCourseCard(@RequestBody CourseCard request) throws Exception {
        return ResponseEntity.ok(courseCardService.saveCourseCard(request));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCourseCards() throws Exception {
        return ResponseEntity.ok(courseCardService.getAllCourseCards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByCourseId(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(courseCardService.getByCourseId(id));
    }

    @PostMapping("/upload/{id}")
    public ResponseEntity<?> uploadFile(@PathVariable UUID id,
            @RequestParam(name = "file", required = false) MultipartFile file) {
        courseCardService.uploadCourseCardImage(file,id);
        return new ResponseEntity<>("File Uploaded Successfully", HttpStatus.OK);
    }
}
