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
@Table(name = "mst_Priority")
public class MstPriority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "priorityId", unique = true, nullable = true)
	private long priorityId;

	@Column(name = "priorityName")
	private String priorityName;

	@Column(name = "description")
	private String description;

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

	
	public long getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(long priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
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
