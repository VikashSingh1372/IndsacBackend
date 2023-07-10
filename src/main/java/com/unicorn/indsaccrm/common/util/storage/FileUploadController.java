package com.unicorn.indsaccrm.common.util.storage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin
@RestController
public class FileUploadController {


    private final FileService fileStorageService;

    public FileUploadController(FileService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam(name = "file", required = false) MultipartFile file
    ) {
        String fileName = fileStorageService.storeFile(file);
        return ResponseEntity.ok().body(fileName);
    }
}
