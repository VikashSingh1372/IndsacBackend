package com.unicorn.indsaccrm.defaultvalues;

import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public interface DefaultValuesRepository extends JpaRepository<DefaultValues, UUID> {
}
