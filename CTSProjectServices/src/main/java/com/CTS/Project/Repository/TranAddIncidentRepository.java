package com.CTS.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CTS.Project.Models.TranAddIncident;

@Repository
public interface TranAddIncidentRepository extends JpaRepository<TranAddIncident, Long>{

	TranAddIncident findAllByTaiApplicationIdAppIdOrderByAutoIncidentId(Class<TranAddIncident> class1, Long appId);

	
	}
