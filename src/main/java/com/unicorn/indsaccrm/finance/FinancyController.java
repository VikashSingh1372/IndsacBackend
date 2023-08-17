package com.unicorn.indsaccrm.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@Controller
@RequestMapping("/finance")
public class FinancyController {

    @Autowired
    FinanceService financeService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam(name = "file", required = false) MultipartFile file
    ) {
        return ResponseEntity.ok().body(financeService.analyseTradebook(file));
    }
}
