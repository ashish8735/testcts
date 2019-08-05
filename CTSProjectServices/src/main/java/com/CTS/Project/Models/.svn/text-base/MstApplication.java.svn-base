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
@Table(name = "mst_application")
public class MstApplication {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "applicationId", unique = true, nullable = false)
    private long appId;

    @Column(name = "applicationName")
    private String applicationName;

    @Column(name = "abbreviationName")
    private String abbreviationName;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
    private Boolean isActive = true;
    
    @JsonIgnore
    @CreatedBy
    private String createdBy;

    @JsonIgnore
    @LastModifiedBy
    private String lastModifiedBy;

    @JsonIgnore
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdDate=new Date();

    @JsonIgnore
    @LastModifiedDate
    private Date lastModifiedDate;


	/*public MstApplication(long appId, String applicationName) {
		super();
		this.appId = appId;
		this.applicationName = applicationName;
	}*/

	public long getAppId() {
		return appId;
	}

	public void setAppId(long appId) {
		this.appId = appId;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getAbbreviationName() {
		return abbreviationName;
	}

	public void setAbbreviationName(String abbreviationName) {
		this.abbreviationName = abbreviationName;
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

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
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

	@Override
	public String toString() {
		return "MstApplication [appId=" + appId + ", applicationName=" + applicationName + ", abbreviationName="
				+ abbreviationName + ", description=" + description + ", isActive=" + isActive + ", createdBy="
				+ createdBy + ", lastModifiedBy=" + lastModifiedBy + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}

	
    

}
