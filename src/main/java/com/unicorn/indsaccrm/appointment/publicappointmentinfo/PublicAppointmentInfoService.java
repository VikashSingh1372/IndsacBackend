package com.unicorn.indsaccrm.appointment.publicappointmentinfo;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface PublicAppointmentInfoService {
    ResponseEntity<?> savePublicAppointmentInfo(PublicAppointmentInfo publicAppointmentInfo);
    ResponseEntity<List<PublicAppointmentInfo>> getAllPublicAppointmentInfos();
    ResponseEntity<Optional<PublicAppointmentInfo>> getPublicAppointmentInfoById(UUID id);
}