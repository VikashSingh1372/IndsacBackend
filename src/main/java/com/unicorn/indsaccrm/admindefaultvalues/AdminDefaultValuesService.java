package com.unicorn.indsaccrm.admindefaultvalues;

import com.unicorn.indsaccrm.course.CourseCard;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface AdminDefaultValuesService {

    ResponseEntity<?> saveAdminDefaultValues(AdminDefaultValues request);

    ResponseEntity<List<AdminDefaultValues>> getAllAdminDefaultValues();

    ResponseEntity<Optional<AdminDefaultValues>> getByAdminDefaultValuesId(UUID id);
}
