package com.unicorn.indsaccrm.util.storage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class FileUploadController {


    private final FileStorageService fileStorageService;

    public FileUploadController(FileStorageService fileStorageService) {
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
