package com.unicorn.indsaccrm.sales.subscribe;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface SubscribeService {
    ResponseEntity<?> saveSubscribe(Subscribe request);

    ResponseEntity<List<Subscribe>> getAllSubscribe();

    ResponseEntity<?> getSubscribeById(UUID id);
}
