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
import javax.persistence.Transient;

@Entity
@Table(name="transaction_addincidentreview")
public class TranAddIncidentReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "incidentReviewId", unique = true, nullable = false)
	private Long incidentReviewId;	
		
	@ManyToOne
	@JoinColumn(name = "autoIncidentId")
	private TranAddIncident autoIncidentId;
	
	@ManyToOne
	@JoinColumn(name = "applicationStageId")
	private MstStage applicationStageId;
	
	@ManyToOne
	@JoinColumn(name = "incidentCategoryId")
	private IncidentCategory incidentCategoryId;
	


	@ManyToOne
	@JoinColumn(name = "incidentStateId")
	private MstIncidentState incidentStateId;	
	
	@Column(name = "incidentAnalysis")
	private String incidentAnalysis;
	
	@Column(name = "incidentComments")
	private String incidentComments;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "errorAttachment")
	private String errorAttachment;
	
	@Column(name = "resolutionMannual")
	private String resolutionMannual;
	
	@Column(name = "learning")
	private String learning;
	
	@Column(name = "forwardTo")
	private String forwardTo;
	
	
	@Column(name = "sendToThirdParty", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean sendToThirdParty = true;

	@Column(name = "thirdParyResourceId")
	private String thirdParyResourceId;
	
	@Column(name = "sequence")
	private int sequence;
	
	@Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean isActive = true;
	
	@Column(name = "isEscalate", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean IsEscalate = true;
	
	@Column(name = "reviewBy")
	private String reviewBy;
	
	@Column(name = "reviewDate")
	private Date reviewDate;
	
	@Column(name = "createdDate")
	private Date createdDate=new Date();
	
	@Column(name = "infoRequired", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean infoRequired = true;
	
	@Column(name = "incidentPendingDays", columnDefinition = "integer default 0", nullable = false)
	private int incidentPendingDays=0;
	
	public int getIncidentPendingDays() {
		return incidentPendingDays;
	}

	public void setIncidentPendingDays(int incidentPendingDays) {
		this.incidentPendingDays = incidentPendingDays;
	}

	
	@Transient
	long count;
	@Transient
	long resolvedCount;
	
	public long getResolvedCount() {
		return resolvedCount;
	}

	public void setResolvedCount(long resolvedCount) {
		this.resolvedCount = resolvedCount;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public Long getIncidentReviewId() {
		return incidentReviewId;
	}

	public void setIncidentReviewId(Long incidentReviewId) {
		this.incidentReviewId = incidentReviewId;
	}

	public TranAddIncident getAutoIncidentId() {
		return autoIncidentId;
	}

	public void setAutoIncidentId(TranAddIncident autoIncidentId) {
		this.autoIncidentId = autoIncidentId;
	}

	
	public MstStage getApplicationStageId() {
		return applicationStageId;
	}

	public void setApplicationStageId(MstStage applicationStageId) {
		this.applicationStageId = applicationStageId;
	}

	public IncidentCategory getIncidentCategoryId() {
		return incidentCategoryId;
	}

	public void setIncidentCategoryId(IncidentCategory incidentCategoryId) {
		this.incidentCategoryId = incidentCategoryId;
	}

	public MstIncidentState getIncidentStateId() {
		return incidentStateId;
	}

	public void setIncidentStateId(MstIncidentState incidentStateId) {
		this.incidentStateId = incidentStateId;
	}

	public String getIncidentAnalysis() {
		return incidentAnalysis;
	}

	public void setIncidentAnalysis(String incidentAnalysis) {
		this.incidentAnalysis = incidentAnalysis;
	}

	public String getIncidentComments() {
		return incidentComments;
	}

	public void setIncidentComments(String incidentComments) {
		this.incidentComments = incidentComments;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getErrorAttachment() {
		return errorAttachment;
	}

	public void setErrorAttachment(String errorAttachment) {
		this.errorAttachment = errorAttachment;
	}

	public String getResolutionMannual() {
		return resolutionMannual;
	}

	public void setResolutionMannual(String resolutionMannual) {
		this.resolutionMannual = resolutionMannual;
	}

	public String getLearning() {
		return learning;
	}

	public void setLearning(String learning) {
		this.learning = learning;
	}

	public String getForwardTo() {
		return forwardTo;
	}

	public void setForwardTo(String forwardTo) {
		this.forwardTo = forwardTo;
	}

	public Boolean getSendToThirdParty() {
		return sendToThirdParty;
	}

	public void setSendToThirdParty(Boolean sendToThirdParty) {
		this.sendToThirdParty = sendToThirdParty;
	}

	public String getThirdParyResourceId() {
		return thirdParyResourceId;
	}

	public void setThirdParyResourceId(String thirdParyResourceId) {
		this.thirdParyResourceId = thirdParyResourceId;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsEscalate() {
		return IsEscalate;
	}

	public void setIsEscalate(Boolean isEscalate) {
		IsEscalate = isEscalate;
	}

	public String getReviewBy() {
		return reviewBy;
	}

	public void setReviewBy(String reviewBy) {
		this.reviewBy = reviewBy;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getInfoRequired() {
		return infoRequired;
	}

	public void setInfoRequired(Boolean infoRequired) {
		this.infoRequired = infoRequired;
	}
	
	

	@Override
	public String toString() {
		return "TranAddIncidentReview [incidentReviewId=" + incidentReviewId + ", autoIncidentId=" + autoIncidentId
				+ ", applicationStageId=" + applicationStageId + ", incidentCategoryId=" + incidentCategoryId
				+ ", incidentStateId=" + incidentStateId + ", incidentAnalysis=" + incidentAnalysis
				+ ", incidentComments=" + incidentComments + ", region=" + region + ", errorAttachment="
				+ errorAttachment + ", resolutionMannual=" + resolutionMannual + ", learning=" + learning
				+ ", forwardTo=" + forwardTo + ", sendToThirdParty=" + sendToThirdParty + ", thirdParyResourceId="
				+ thirdParyResourceId + ", sequence=" + sequence + ", isActive=" + isActive + ", IsEscalate="
				+ IsEscalate + ", reviewBy=" + reviewBy + ", reviewDate=" + reviewDate + ", createdDate=" + createdDate
				+ ", infoRequired=" + infoRequired + ", incidentPendingDays=" + incidentPendingDays + ", count=" + count
				+ ", resolvedCount=" + resolvedCount + ", getIncidentPendingDays()=" + getIncidentPendingDays()
				+ ", getResolvedCount()=" + getResolvedCount() + ", getCount()=" + getCount()
				+ ", getIncidentReviewId()=" + getIncidentReviewId() + ", getAutoIncidentId()=" + getAutoIncidentId()
				+ ", getApplicationStageId()=" + getApplicationStageId() + ", getIncidentCategoryId()="
				+ getIncidentCategoryId() + ", getIncidentStateId()=" + getIncidentStateId()
				+ ", getIncidentAnalysis()=" + getIncidentAnalysis() + ", getIncidentComments()="
				+ getIncidentComments() + ", getRegion()=" + getRegion() + ", getErrorAttachment()="
				+ getErrorAttachment() + ", getResolutionMannual()=" + getResolutionMannual() + ", getLearning()="
				+ getLearning() + ", getForwardTo()=" + getForwardTo() + ", getSendToThirdParty()="
				+ getSendToThirdParty() + ", getThirdParyResourceId()=" + getThirdParyResourceId() + ", getSequence()="
				+ getSequence() + ", getIsActive()=" + getIsActive() + ", getIsEscalate()=" + getIsEscalate()
				+ ", getReviewBy()=" + getReviewBy() + ", getReviewDate()=" + getReviewDate() + ", getCreatedDate()="
				+ getCreatedDate() + ", getInfoRequired()=" + getInfoRequired() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
