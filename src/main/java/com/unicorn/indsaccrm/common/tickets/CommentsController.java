package com.unicorn.indsaccrm.common.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    CommentsService commentsService;
    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE })
    ResponseEntity<?>saveComments(@RequestBody Comments comments,@RequestParam(name = "file", required = false)
    MultipartFile file)throws Exception{
        return commentsService.saveComments(comments,file);
    }
    @GetMapping("/all")
    ResponseEntity<?>gettingAllRequest() throws Exception{
        return commentsService.getallrequest();
    }
    @GetMapping("/{id}")
    ResponseEntity<?>getByid(@PathVariable UUID id)throws Exception{
        return commentsService.getByID(id);
    }
    @PutMapping("/{id}")
    ResponseEntity<?>updateComments(@PathVariable UUID id, @RequestBody Comments comments)throws Exception{
        Comments getnewcomments=commentsService.getByID(id).getBody().orElse(null);
        if (getnewcomments==null){
            return ResponseEntity.notFound().build();
        }else {
            getnewcomments.setUploadfile(comments.getUploadfile());
            getnewcomments.setUserid(comments.getUserid());
            getnewcomments.setCommenttext(comments.getCommenttext());
            getnewcomments.setTicketid(comments.getTicketid());
        }
        commentsService.saveComments(getnewcomments,null);
        return new ResponseEntity<>("updated successfully",HttpStatus.OK);
    }

    @GetMapping("/ticket/{ticketid}")
    ResponseEntity<?>getByTicketid(@PathVariable UUID ticketid)throws Exception{
        return commentsService.getByTicketId(ticketid);
    }

    @GetMapping("/ticketnumber/{ticketnumber}")
    ResponseEntity<?>getByTicketid(@PathVariable long ticketnumber)throws Exception{
        return commentsService.getByTicketNumber(ticketnumber);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?>deletecontroller(@PathVariable UUID id)throws Exception{
        Comments deleteone=commentsService.getByID(id).getBody().orElse(null);
        if (deleteone==null){
            return ResponseEntity.notFound().build();
        }
        commentsService.deleteComments(deleteone);
        return new ResponseEntity<>("delete successfully",HttpStatus.OK);
    }
    @PostMapping("/upload/{commentId}")
    ResponseEntity<String>uploadcomfile(@PathVariable UUID commentId,@RequestParam(name = "file",required = false)MultipartFile file){
        if (file==null){
            return ResponseEntity.badRequest().body("No file provided");
        }
        try {
            String comfilename=String.valueOf(commentsService.uploadfilecomments(commentId,file));
            return ResponseEntity.ok().body(comfilename);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file uploade failed");
        }
    }

    @GetMapping("/file/{commentId}/{filename}")
    public ResponseEntity<Resource> getFile(@PathVariable UUID commentId, @PathVariable String filename) throws IOException {
        return commentsService.getFile(commentId,filename);
    }

}
