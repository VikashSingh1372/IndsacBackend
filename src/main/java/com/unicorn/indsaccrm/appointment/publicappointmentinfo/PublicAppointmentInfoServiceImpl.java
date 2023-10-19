package com.unicorn.indsaccrm.appointment.publicappointmentinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class PublicAppointmentInfoServiceImpl implements PublicAppointmentInfoService {
   @Autowired
   PublicAppointmentInfoRepository publicAppointmentInfoRepository;
   Logger logger = LoggerFactory.getLogger(PublicAppointmentInfoServiceImpl.class);
   @Override
   public ResponseEntity<?> savePublicAppointmentInfo(PublicAppointmentInfo publicAppointmentInfo) {
      logger.info("Save PublicAppointmentInfo from savePublicAppointmentInfo Successully");
      return ResponseEntity.ok(publicAppointmentInfoRepository.save(publicAppointmentInfo));
   }
   @Override
   public ResponseEntity<List<PublicAppointmentInfo>> getAllPublicAppointmentInfos() {
      logger.info("GET all PublicAppointmentInfos from getAllPublicAppointmentInfos Successully");
      return ResponseEntity.ok(publicAppointmentInfoRepository.findAll());
   }
   @Override
   public ResponseEntity<Optional<PublicAppointmentInfo>> getPublicAppointmentInfoById(UUID id) {
      logger.info("GET PublicAppointmentInfo By Id from getPublicAppointmentInfoById Successfully");
      return ResponseEntity.ok(publicAppointmentInfoRepository.findById(id));
   }
}