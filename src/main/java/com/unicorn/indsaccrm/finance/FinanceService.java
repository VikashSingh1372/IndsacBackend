package com.unicorn.indsaccrm.finance;


import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FinanceService {
    ResponseEntity<?> analyseTradebook(MultipartFile file);
}
