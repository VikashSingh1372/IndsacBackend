package com.unicorn.indsaccrm.common.tickets;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentsService {
    ResponseEntity<?> saveComments(Comments request,MultipartFile file);
    ResponseEntity<List<Comments>> getallrequest();
    ResponseEntity<Optional<Comments>>getByID(UUID id);
    ResponseEntity<?>deleteComments(Comments comments);
    ResponseEntity<Optional<Comments>>upateById(UUID id);
    ResponseEntity<String>uploadfilecomments(UUID commentId,MultipartFile comfile);

    ResponseEntity<Resource> getFile(UUID commentId, String fileName) throws IOException;

    ResponseEntity<List<Comments>> getByTicketId(UUID ticketId);

    ResponseEntity<List<Comments>> getByTicketNumber(long ticketNumber);
}
