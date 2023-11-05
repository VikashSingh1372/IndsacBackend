package com.unicorn.indsaccrm.customize.uitheme;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface UIThemeService {
    ResponseEntity<?> saveUITheme(UITheme uITheme);
    ResponseEntity<List<UITheme>> getAllUIThemes();
    ResponseEntity<Optional<UITheme>> getUIThemeById(UUID id);
}