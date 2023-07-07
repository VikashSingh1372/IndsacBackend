package com.unicorn.indsaccrm.clientticketresponse;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientTicketResponseRepository extends JpaRepository<ClientTicketResponse, UUID> {
    List<ClientTicketResponse> findByCustomerid(UUID customerid);

    List<ClientTicketResponse> findByUsercid(UUID usercid);

    List<ClientTicketResponse> findByUseradminid(UUID useradminid);




}
