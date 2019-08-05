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
@Table(name="transaction_incidentattachment")
public class Tranincidentattachment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "incidentAttachmentId", unique = true, nullable = false)
	private long incidentAttachmentId;	
	
	@Column(name = "AutoIncidentID")
	private String AutoIncidentID;
	
	@ManyToOne
	@JoinColumn(name="applicationId")
	private MstApplication applicationId;
	
	@Column(name="attachmentName")
	private String attachmentName;
	
	@Column(name="attachmentPath")
	private String attachmentPath;
	
	@Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean isActive = true;

	@JsonIgnore
	@CreatedBy
	private String createdBy;

	@JsonIgnore
	@LastModifiedBy
	private String lastModifiedBy;


	@CreatedDate
	@Column(nullable = false)
	private Date createdDate=new Date();

	@JsonIgnore
	@LastModifiedDate
	private Date lastModifiedDate;

	public long getIncidentAttachmentId() {
		return incidentAttachmentId;
	}

	public void setIncidentAttachmentId(long incidentAttachmentId) {
		this.incidentAttachmentId = incidentAttachmentId;
	}

	public String getAutoIncidentID() {
		return AutoIncidentID;
	}

	public void setAutoIncidentID(String autoIncidentID) {
		AutoIncidentID = autoIncidentID;
	}

	

	public MstApplication getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(MstApplication applicationId) {
		this.applicationId = applicationId;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
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
	
	
}
