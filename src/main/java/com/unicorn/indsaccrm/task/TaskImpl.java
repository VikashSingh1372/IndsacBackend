package com.unicorn.indsaccrm.task;

import com.unicorn.indsaccrm.ProjectManagement.ProjectTasks.ProjectTasks.ProjectTasksStatus;
import com.unicorn.indsaccrm.admindefaultvalues.AdminDefaultValuesService;
import com.unicorn.indsaccrm.task.Task.TaskStatus;
import java.time.LocalDate;
import java.util.Objects;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class TaskImpl implements TaskService{
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    private AdminDefaultValuesService adminDefaultValuesService;

    Logger logger = LoggerFactory.logger(TaskImpl.class);
    @Override
    public ResponseEntity<?> saveAllTask(Task task) {
        if(task.getDuedate()==null){
            LocalDate date=LocalDate.now().plusDays(Objects.requireNonNull(adminDefaultValuesService
                    .getByAdminDefaultValuesId(task.getUseradminid()).getBody())
                .getInvoiceduedayperiod());
            task.setDuedate(date);
        }
        taskRepository.save(task);
        return ResponseEntity.ok(taskRepository.save(task));
    }

    @Override
    public ResponseEntity<List<Task>> getAllTask() {
        logger.info("all task getting successfully");
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @Override
    public ResponseEntity<Optional<Task>> getByIdtask(UUID id) {
        logger.info("all task getting by id");
        return ResponseEntity.ok(taskRepository.findById(id));
    }

    @Override
    public ResponseEntity<List<Task>> getTaskByCustomerId(UUID id) {
        logger.info("Get tasks by UserCustomerId");
        return ResponseEntity.ok(taskRepository.findByCustomerid(id));
    }

    @Override
    public ResponseEntity<List<Task>> getTaskByUserAdminId(UUID id) {
        logger.info("Get tasks by UserAdminId");
        return ResponseEntity.ok(taskRepository.findByUseradminid(id));
    }

    @Override
    public ResponseEntity<List<Task>> getAllTaskByDueDateAndStatusNotIn(UUID customerid,
        UUID useradminid,LocalDate dueDate,List<TaskStatus> statusList) {
        return ResponseEntity.ok(taskRepository
            .findByCustomeridAndUseradminidAndDuedateLessThanEqualAndStatusNotIn(
                customerid,useradminid,dueDate,statusList));
    }
    @Override
    public ResponseEntity<List<Task>> getAllTaskByStatusNotIn(UUID customerid,
        UUID useradminid,List<TaskStatus> statusList) {
        return ResponseEntity.ok(taskRepository
            .findByCustomeridAndUseradminidAndStatusNotIn(
                customerid,useradminid,statusList));
    }

    @Override
    public ResponseEntity<List<Task>> getTaskByLeadid(UUID leadid) {
        logger.info("Get tasks by lead_id from getTaskByLeadid Successfully");
        return ResponseEntity.ok(taskRepository.findByLeadid(leadid));
    }

    @Override
    public ResponseEntity<List<Task>> getTaskByVendorid(UUID vendorid) {
        logger.info("Get tasks by vendor_id from getTaskByVendorid Successfully");
        return ResponseEntity.ok(taskRepository.findByVendorid(vendorid));
    }
}
