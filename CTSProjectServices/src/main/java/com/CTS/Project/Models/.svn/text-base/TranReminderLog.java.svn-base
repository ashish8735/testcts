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
@Table(name = "tran_reminder_log")
public class TranReminderLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reminderId", unique = true, nullable = false)
	private Long reminderId;	
	
	@ManyToOne
	@JoinColumn(name = "incidentReviewId")
	private TranAddIncidentReview incidentReviewId;
	
	@ManyToOne
	@JoinColumn(name = "pendingAt")//asignto
	private MstResourcePool pendingAt;
	
	@ManyToOne
	@JoinColumn(name = "reminderBy")//createduser
	private MstResourcePool reminderBy;
	
	@Column(name="reminderDate")
	private Date reminderDate;
	
	@Column(name = "remark", length = 2000)
	private String remark;
	
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
	private Date createdDate = new Date();

	@JsonIgnore
	@LastModifiedDate
	private Date lastModifiedDate=new Date();

	public Long getReminderId() {
		return reminderId;
	}

	public void setReminderId(Long reminderId) {
		this.reminderId = reminderId;
	}

	public TranAddIncidentReview getIncidentReviewId() {
		return incidentReviewId;
	}

	public void setIncidentReviewId(TranAddIncidentReview incidentReviewId) {
		this.incidentReviewId = incidentReviewId;
	}

	public MstResourcePool getPendingAt() {
		return pendingAt;
	}

	public void setPendingAt(MstResourcePool pendingAt) {
		this.pendingAt = pendingAt;
	}

	public MstResourcePool getReminderBy() {
		return reminderBy;
	}

	public void setReminderBy(MstResourcePool reminderBy) {
		this.reminderBy = reminderBy;
	}

	public Date getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(Date reminderDate) {
		this.reminderDate = reminderDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		return "TranReminderLog [reminderId=" + reminderId + ", incidentReviewId=" + incidentReviewId + ", pendingAt="
				+ pendingAt + ", reminderBy=" + reminderBy + ", reminderDate=" + reminderDate + ", remark=" + remark
				+ ", isActive=" + isActive + ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy
				+ ", createdDate=" + createdDate + ", lastModifiedDate=" + lastModifiedDate + "]";
	}
	
}
