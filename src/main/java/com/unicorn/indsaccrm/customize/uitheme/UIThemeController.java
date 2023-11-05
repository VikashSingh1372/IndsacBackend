package com.unicorn.indsaccrm.customize.uitheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@CrossOrigin
@Controller
@RequestMapping("/uitheme")
public class UIThemeController {
    @Autowired
    private UIThemeService uIThemeService;
    @PostMapping
    ResponseEntity<?> createUITheme(@RequestBody UITheme uITheme) throws Exception {
        return ResponseEntity.ok(uIThemeService.saveUITheme(uITheme));
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllUITheme() throws Exception {
        return ResponseEntity.ok(uIThemeService.getAllUIThemes());
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getUIThemeByID(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok(uIThemeService.getUIThemeById(id));
    }
}