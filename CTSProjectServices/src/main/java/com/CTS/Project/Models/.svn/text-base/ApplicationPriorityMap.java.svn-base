package com.CTS.Project.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Mapping_ApplicationPriority")
public class ApplicationPriorityMap {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "applicationPriorityID")
	private Long applicationPriorityID;

	@ManyToOne
	@JoinColumn(name = "mapApplicationId")
	private MstApplication mapApplicationId;

	@Column(name = "applicationId")
	private int applicationId;

	@ManyToOne
	@JoinColumn(name = "mapPriorityId")
	private MstPriority mapPriorityId;

	@Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean isActive = true;

	@Column(name = "configureOrder")
	private int configureOrder;

	@JsonIgnore
	@CreatedBy
	@Column(name = "createdBy")
	private String createdBy;

	@JsonIgnore
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private Date createdDate = new Date();

	@JsonIgnore
	@LastModifiedBy
	private String modifiedBy;

	@JsonIgnore
	@LastModifiedDate
	private Date lastModifiedDate = new Date();

	public Long getApplicationPriorityID() {
		return applicationPriorityID;
	}

	public void setApplicationPriorityID(Long applicationPriorityID) {
		this.applicationPriorityID = applicationPriorityID;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	
	public MstApplication getMapApplicationId() {
		return mapApplicationId;
	}

	public void setMapApplicationId(MstApplication mapApplicationId) {
		this.mapApplicationId = mapApplicationId;
	}

	public MstPriority getMapPriorityId() {
		return mapPriorityId;
	}

	public void setMapPriorityId(MstPriority mapPriorityId) {
		this.mapPriorityId = mapPriorityId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public int getConfigureOrder() {
		return configureOrder;
	}

	public void setConfigureOrder(int configureOrder) {
		this.configureOrder = configureOrder;
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

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}