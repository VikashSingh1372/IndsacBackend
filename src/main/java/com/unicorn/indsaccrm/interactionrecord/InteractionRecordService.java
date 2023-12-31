package com.unicorn.indsaccrm.interactionrecord;

import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InteractionRecordService {
    ResponseEntity<?>saveAllInteraction(InteractionRecord request);
    ResponseEntity<List<InteractionRecord>>getAllInteraction();
    ResponseEntity<Optional<InteractionRecord>>getByIdInteraction(UUID id);
    ResponseEntity<List<InteractionRecord>> getInteractionRecordByCustomerId(UUID id);
    ResponseEntity<List<InteractionRecord>> getInteractionRecordByUserAdminId(UUID id);
}
