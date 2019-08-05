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
@Table(name = "mst_ApplicationTiming")
public class ApplicationTiming {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "applicationTimingId")
	private Long applicationTimingId;

	// @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "mstApplicationId")
	private MstApplication matApplicationId;

	@Column(name = "sunday", columnDefinition = "binary(1) default false")
	private Boolean sunday = false;

	@Column(name = "monday", columnDefinition = "binary(1) default false")
	private Boolean monday = false;

	@Column(name = "tuesday", columnDefinition = "binary(1) default false")
	private Boolean tuesday = false;

	@Column(name = "wednesday", columnDefinition = "binary(1) default false")
	private Boolean wednesday = false;

	@Column(name = "thursday", columnDefinition = "binary(1) default false")
	private Boolean thursday = false;

	@Column(name = "friday", columnDefinition = "binary(1) default false")
	private Boolean friday = false;

	@Column(name = "saturday", columnDefinition = "binary(1) default false")
	private Boolean saturday = false;

	@Column(name = "startTime")
	private String startTime;

	@Column(name = "endTime")
	private String endTime;

	@Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean isActive = true;

	@JsonIgnore
	@CreatedBy
	@Column(name = "createdBy")
	private String createdBy;

	@JsonIgnore
	@LastModifiedBy
	private String modifiedBy;

	@JsonIgnore
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private Date createdDate = new Date();

	@JsonIgnore
	@LastModifiedDate
	private Date lastModifiedDate = new Date();
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Long getApplicationTimingId() {
		return applicationTimingId;
	}

	public void setApplicationTimingId(Long applicationTimingId) {
		this.applicationTimingId = applicationTimingId;
	}

	public MstApplication getMatApplicationId() {
		return matApplicationId;
	}

	public void setMatApplicationId(MstApplication matApplicationId) {
		this.matApplicationId = matApplicationId;
	}

	public Boolean getSunday() {
		return sunday;
	}

	public void setSunday(Boolean sunday) {
		this.sunday = sunday;
	}

	public Boolean getMonday() {
		return monday;
	}

	public void setMonday(Boolean monday) {
		this.monday = monday;
	}

	public Boolean getTuesday() {
		return tuesday;
	}

	public void setTuesday(Boolean tuesday) {
		this.tuesday = tuesday;
	}

	public Boolean getWednesday() {
		return wednesday;
	}

	public void setWednesday(Boolean wednesday) {
		this.wednesday = wednesday;
	}

	public Boolean getThursday() {
		return thursday;
	}

	public void setThursday(Boolean thursday) {
		this.thursday = thursday;
	}

	public Boolean getFriday() {
		return friday;
	}

	public void setFriday(Boolean friday) {
		this.friday = friday;
	}

	public Boolean getSaturday() {
		return saturday;
	}

	public void setSaturday(Boolean saturday) {
		this.saturday = saturday;
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

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}