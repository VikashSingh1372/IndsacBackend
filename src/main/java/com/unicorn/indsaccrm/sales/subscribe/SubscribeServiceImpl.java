package com.unicorn.indsaccrm.sales.subscribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubscribeServiceImpl implements SubscribeService{
    @Autowired
    SubscribeRepository subscribeRepository;
    @Override
    public ResponseEntity<?> saveSubscribe(Subscribe request) {
        subscribeRepository.save(request);
        return new ResponseEntity<>("Submitted successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Subscribe>> getAllSubscribe() {
        return  new ResponseEntity<>(subscribeRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getSubscribeById(UUID id) {
        return ResponseEntity.ok(subscribeRepository.findById(id));
    }
}
