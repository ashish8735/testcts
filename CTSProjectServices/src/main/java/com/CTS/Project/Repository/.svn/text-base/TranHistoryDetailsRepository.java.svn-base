package com.CTS.Project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CTS.Project.Models.TranHistoryDetails;

public interface TranHistoryDetailsRepository extends JpaRepository<TranHistoryDetails, Long> {

	List<TranHistoryDetails>  findAllByHistoryIncidentReviewIdIncidentReviewIdAndIsActiveTrue(Long incidentReviewId);

}
