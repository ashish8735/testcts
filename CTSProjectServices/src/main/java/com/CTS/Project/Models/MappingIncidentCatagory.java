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

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "mst_map_incident_category")
public class MappingIncidentCatagory 
{

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mapincidentCatagory_id", unique = true, nullable = false)
    private long mapincidentCatagoryId;
  
    
    @ManyToOne
	@JoinColumn(name = "micApplicationId")
	private MstApplication micApplicationId;
    
    @ManyToOne
   	@JoinColumn(name = "micIncidentcategoryId")
   	private IncidentCategory micIncidentcategoryId;
    
    @Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
    private Boolean isActive = true;

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
	private Date modifiedDate=new Date();
	

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

	public long getMapincidentCatagoryId() {
		return mapincidentCatagoryId;
	}

	public void setMapincidentCatagoryId(long mapincidentCatagoryId) {
		this.mapincidentCatagoryId = mapincidentCatagoryId;
	}

	

	public MstApplication getMicApplicationId() {
		return micApplicationId;
	}

	public void setMicApplicationId(MstApplication micApplicationId) {
		this.micApplicationId = micApplicationId;
	}

	public IncidentCategory getMicIncidentcategoryId() {
		return micIncidentcategoryId;
	}

	public void setMicIncidentcategoryId(IncidentCategory micIncidentcategoryId) {
		this.micIncidentcategoryId = micIncidentcategoryId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

    
    
	
}
