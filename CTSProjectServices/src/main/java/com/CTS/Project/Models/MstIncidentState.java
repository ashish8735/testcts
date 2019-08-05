package com.CTS.Project.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="mst_incidentstate")
public class MstIncidentState {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "incidentStateId", unique = true, nullable = false)
	private long incidentStateId;
	
	
	
	@Column(name = "incidentStateName")
	private String incidentStateName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean isActive = true;
	

	@Column(name = "editable", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean editable  = true;
	
	@JsonIgnore
    @CreatedBy
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
	private Date modifiedDate;
	
	
	public long getIncidentStateId() {
		return incidentStateId;
	}

	public void setIncidentStateId(long incidentStateId) {
		this.incidentStateId = incidentStateId;
	}

	public String getIncidentStateName() {
		return incidentStateName;
	}

	public void setIncidentStateName(String incidentStateName) {
		this.incidentStateName = incidentStateName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
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
