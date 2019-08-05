package com.CTS.Project.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "mst_incident_Category")
public class IncidentCategory 
{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	
	 @Column(name = "incidentcategoryId")
    private int incidentcategoryId;
    
	@Column(name = "incidentcategoryName")
    private String incidentcategoryName;
    
    @Column(name = "description")
    private String description;
    
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
	private Date modifiedDate = new Date();
	
	 public int getIncidentcategoryId() {
		return incidentcategoryId;
	}

	public void setIncidentcategoryId(int incidentcategoryId) {
		this.incidentcategoryId = incidentcategoryId;
	}

	
	public String getIncidentcategoryName() {
		return incidentcategoryName;
	}

	public void setIncidentcategoryName(String incidentcategoryName) {
		this.incidentcategoryName = incidentcategoryName;
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

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
    
    
    
}
