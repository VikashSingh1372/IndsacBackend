package com.unicorn.indsaccrm.customize.uitheme;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface UIThemeRepository extends JpaRepository<UITheme,UUID> {
}
