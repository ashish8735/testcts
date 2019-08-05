package com.CTS.Project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.TranReminderLog;

public interface TranReminderLogRepository extends JpaRepository<TranReminderLog, Long> {

	List<TranReminderLog>  findAllByIncidentReviewIdIncidentReviewIdAndIsActiveTrue(Long incidentReviewId);

}
