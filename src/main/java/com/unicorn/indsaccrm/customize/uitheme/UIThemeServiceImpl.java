package com.unicorn.indsaccrm.customize.uitheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UIThemeServiceImpl implements UIThemeService {
   @Autowired
   UIThemeRepository uIThemeRepository;
   Logger logger = LoggerFactory.getLogger(UIThemeServiceImpl.class);
   @Override
   public ResponseEntity<?> saveUITheme(UITheme uITheme) {
      logger.info("Save UITheme from saveUITheme Successully");
      return ResponseEntity.ok(uIThemeRepository.save(uITheme));
   }
   @Override
   public ResponseEntity<List<UITheme>> getAllUIThemes() {
      logger.info("GET all UIThemes from getAllUIThemes Successully");
      return ResponseEntity.ok(uIThemeRepository.findAll());
   }
   @Override
   public ResponseEntity<Optional<UITheme>> getUIThemeById(UUID id) {
      logger.info("GET UITheme By Id from getUIThemeById Successfully");
      return ResponseEntity.ok(uIThemeRepository.findById(id));
   }
}