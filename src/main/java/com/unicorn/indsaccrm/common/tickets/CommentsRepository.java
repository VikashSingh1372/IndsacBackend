package com.unicorn.indsaccrm.common.tickets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface CommentsRepository extends JpaRepository<Comments, UUID> {
    List<Comments> findByTicketid(UUID ticketid);

    List<Comments> findByTicketnumber(long ticketnumber);



}
