package com.unicorn.indsaccrm.defaultvalues;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public interface DefaultValuesService {
    ResponseEntity<?>saveAllValues(DefaultValues request);
    ResponseEntity<List<DefaultValues>>getAllValue();
    ResponseEntity<Optional<DefaultValues>>getByIdValues(UUID id);
}
