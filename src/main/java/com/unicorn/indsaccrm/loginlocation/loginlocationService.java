package com.unicorn.indsaccrm.loginlocation;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface loginlocationService {
    ResponseEntity<?> saveloginlocation(loginlocation loginlocation);
    ResponseEntity<List<loginlocation>> getAllloginlocations();
    ResponseEntity<Optional<loginlocation>> getloginlocationById(UUID id);
}