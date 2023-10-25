package com.unicorn.indsaccrm.loginlocation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface loginlocationRepository extends JpaRepository<loginlocation,UUID> {
}
