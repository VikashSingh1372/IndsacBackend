package com.unicorn.indsaccrm.common.tickets;

import com.unicorn.indsaccrm.common.exception.ResourceNotFoundException;
import com.unicorn.indsaccrm.common.util.storage.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class CommentsServiceImpl implements CommentsService{
    Logger logger= LoggerFactory.getLogger(Comments.class);

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    FileService fileService;

    @Override
    public ResponseEntity<?> saveComments(Comments request, MultipartFile file) {
        request.setUploadfile(file!=null?fileService.storeFile(file):null);
        return new ResponseEntity<>(commentsRepository.save(request) , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Comments>> getallrequest() {
        logger.info("submitted successfully");
        return ResponseEntity.ok(commentsRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Comments>> getByID(UUID id) {
        logger.info("getting data successfully");
        return ResponseEntity.ok(commentsRepository.findById(id));
    }

    @Override
    public ResponseEntity<?> deleteComments(Comments comments) {
        UUID id=comments.getId();
        Optional<Comments>gettingcomments=commentsRepository.findById(id);
        if (gettingcomments.isPresent()){
            return ResponseEntity.notFound().build();
        }
        commentsRepository.delete(comments);
        return ResponseEntity.ok("deleted successfully");
    }

    @Override
    public ResponseEntity<Optional<Comments>> upateById(UUID id) {
        logger.info("updated successfully", HttpStatus.OK);
        return ResponseEntity.ok(commentsRepository.findById(id));
    }

    @Override
    public ResponseEntity<String> uploadfilecomments(UUID commentId,MultipartFile file) {
        if (file.isEmpty()){
            ResponseEntity.badRequest().body("File is Empty");
        }
        Comments comments = commentsRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException(" Not found"));
        String uploadedFileName = fileService.storeFile(file);
        if(comments.getUploadfile()!=null){
            comments.setUploadfile(comments.getUploadfile()+","+uploadedFileName);
        }else{
            comments.setUploadfile(uploadedFileName);
        }
        commentsRepository.save(comments);
        return ResponseEntity.ok().body(uploadedFileName);

    }

    @Override
    public ResponseEntity<Resource> getFile(UUID commentId, String fileName) throws IOException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(fileService.getFile(fileName));
    }

    @Override
    public ResponseEntity<List<Comments>> getByTicketId(UUID ticketId) {
        return ResponseEntity.ok(commentsRepository.findByTicketid(ticketId));
    }

    @Override
    public ResponseEntity<List<Comments>> getByTicketNumber(long ticketNumber) {
        return ResponseEntity.ok(commentsRepository.findByTicketnumber(ticketNumber));
    }
}
