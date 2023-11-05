package com.unicorn.indsaccrm.task;

import com.unicorn.indsaccrm.task.Task.TaskStatus;
import java.time.LocalDate;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
@Service
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByCustomerid(UUID customerid);

    List<Task> findByUseradminid(UUID useradminid);

    List<Task> findByCustomeridAndUseradminidAndDuedateLessThanEqualAndStatusNotIn(UUID customerid,
        UUID useradminid, LocalDate duedate, List<TaskStatus> statuses);

    List<Task> findByCustomeridAndUseradminidAndStatusNotIn(UUID customerid,
        UUID useradminid, List<TaskStatus> statuses);

    List<Task> findByLeadid(UUID leadid);

    List<Task> findByVendorid(UUID vendorid);
}
