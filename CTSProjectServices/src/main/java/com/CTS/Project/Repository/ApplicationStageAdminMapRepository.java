package com.CTS.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CTS.Project.Models.ApplicationStageAdminMap;
@Repository
public interface ApplicationStageAdminMapRepository extends JpaRepository<ApplicationStageAdminMap, Long>{

}
