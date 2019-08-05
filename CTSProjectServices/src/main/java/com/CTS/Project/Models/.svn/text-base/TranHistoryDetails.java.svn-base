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
@Table(name = "tran_history_details")
public class TranHistoryDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "historyId", unique = true, nullable = false)
	private Long historyId;	
	
	@ManyToOne
	@JoinColumn(name = "historyIncidentReviewId")
	private TranAddIncidentReview historyIncidentReviewId;
	
	@ManyToOne
	@JoinColumn(name = "historyIncidentStateId")
	private MstIncidentState historyIncidentStateId;
	
	@ManyToOne
	@JoinColumn(name = "historyAssighToResourceId")
	private MstResourcePool historyAssighToResourceId;
	
	@ManyToOne
	@JoinColumn(name = "historyCreatedUserResourceId")
	private MstResourcePool historyCreatedUserResourceId;
	
	@ManyToOne
	@JoinColumn(name = "historyPriorityId")
	private MstPriority historyPriorityId;
	
	@ManyToOne
	@JoinColumn(name = "historyIncidentAttachmentId")
	private Tranincidentattachment historyIncidentAttachmentId;
	
	@Column(name="historyRemark")
	private String historyRemark;
	
	@Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean isActive = true;

	@JsonIgnore
	@CreatedBy
	private String createdBy;

	@JsonIgnore
	@LastModifiedBy
	private String lastModifiedBy;

	//@JsonIgnore
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private Date createdDate = new Date();

	@JsonIgnore
	@LastModifiedDate
	private Date lastModifiedDate=new Date();

	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public TranAddIncidentReview getHistoryIncidentReviewId() {
		return historyIncidentReviewId;
	}

	public void setHistoryIncidentReviewId(TranAddIncidentReview historyIncidentReviewId) {
		this.historyIncidentReviewId = historyIncidentReviewId;
	}

	public MstIncidentState getHistoryIncidentStateId() {
		return historyIncidentStateId;
	}

	public void setHistoryIncidentStateId(MstIncidentState historyIncidentStateId) {
		this.historyIncidentStateId = historyIncidentStateId;
	}

	public MstResourcePool getHistoryAssighToResourceId() {
		return historyAssighToResourceId;
	}

	public void setHistoryAssighToResourceId(MstResourcePool historyAssighToResourceId) {
		this.historyAssighToResourceId = historyAssighToResourceId;
	}

	public MstResourcePool getHistoryCreatedUserResourceId() {
		return historyCreatedUserResourceId;
	}

	public void setHistoryCreatedUserResourceId(MstResourcePool historyCreatedUserResourceId) {
		this.historyCreatedUserResourceId = historyCreatedUserResourceId;
	}

	public Tranincidentattachment getHistoryIncidentAttachmentId() {
		return historyIncidentAttachmentId;
	}

	public void setHistoryIncidentAttachmentId(Tranincidentattachment historyIncidentAttachmentId) {
		this.historyIncidentAttachmentId = historyIncidentAttachmentId;
	}

	public String getHistoryRemark() {
		return historyRemark;
	}

	public void setHistoryRemark(String historyRemark) {
		this.historyRemark = historyRemark;
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

	public MstPriority getHistoryPriorityId() {
		return historyPriorityId;
	}

	public void setHistoryPriorityId(MstPriority historyPriorityId) {
		this.historyPriorityId = historyPriorityId;
	}
	
	
}
