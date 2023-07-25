package com.unicorn.indsaccrm.SocialMedia.LinkedIn;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LinkedinRepository extends JpaRepository<LinkedIn, UUID> {
    List<LinkedIn> findByUserid(UUID userid);

    List<LinkedIn> findByOrgid(UUID orgid);


}
