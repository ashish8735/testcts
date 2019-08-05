package com.CTS.Project.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "mapping_applicationstage")
public class MappingApplicationStage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "applicationStageId", unique = true, nullable = false)
	private long applicationStageId;

	@JsonInclude()
	@ManyToOne
	@JoinColumn(name = "applicationId")
	private MstApplication mapStageapplicationId;
	 
	@JsonInclude()
	@ManyToOne
	@JoinColumn(name = "stageId")
	private MstStage stageId;
	
	@JsonInclude()
	@ManyToOne
	@JoinColumn(name = "resourceId")
	private MstResourcePool mapresourceId;	
		 	
	@Column(name = "configureOrder")
	private int configureOrder;

	@Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean isActive = true;

	@JsonIgnore
    @CreatedBy
    @Column(name = "createdBy")
	private String createdBy;
	
	@JsonIgnore
    @CreatedDate
	@Column(name = "createdDate")
	private Date createdDate=new Date();
	
	@JsonIgnore
    @LastModifiedBy
	@Column(name = "modifiedBy")
	private String modifiedBy;
	
	@JsonIgnore
    @LastModifiedDate
	@Column(name = "modifiedDate")
	private Date modifiedDate=new Date();

	public long getApplicationStageId() {
		return applicationStageId;
	}

	public void setApplicationStageId(long applicationStageId) {
		this.applicationStageId = applicationStageId;
	}

	public MstApplication getMapStageapplicationId() {
		return mapStageapplicationId;
	}

	public void setMapStageapplicationId(MstApplication mapStageapplicationId) {
		this.mapStageapplicationId = mapStageapplicationId;
	}

	public MstStage getStageId() {
		return stageId;
	}

	public void setStageId(MstStage stageId) {
		this.stageId = stageId;
	}

	public MstResourcePool getMapresourceId() {
		return mapresourceId;
	}

	public void setMapresourceId(MstResourcePool mapresourceId) {
		this.mapresourceId = mapresourceId;
	}

	public int getConfigureOrder() {
		return configureOrder;
	}

	public void setConfigureOrder(int configureOrder) {
		this.configureOrder = configureOrder;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	
}
