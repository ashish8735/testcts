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
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transaction_addincident")
public class TranAddIncident {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "autoIncidentId", unique = true, nullable = false)
	private Long autoIncidentId;

	@Column(name = "IncidentId")
	private String IncidentId;

	@ManyToOne
	@JoinColumn(name = "tiaApplicationId")
	private MstApplication taiApplicationId;
	
	@ManyToOne
	@JoinColumn(name = "taiIncidentStateId")
	private MstIncidentState taiIncidentStateId;

	@ManyToOne
	@JoinColumn(name = "taiPriorityId")
	private MstPriority taiPriorityId;

	@ManyToOne	
	@JoinColumn(name = "taiIncidentTypeId")
	private MstIncidentType taiIncidentTypeId;

	@ManyToOne
	@JoinColumn(name = "taiIncidentSubTypeId")
	private MstIncidentSubType taiIncidentSubTypeId;
	
	@Column(name = "mobileNo")
	private String mobileNo;

	@Column(name = "subject")
	private String subject;

	@Column(name = "incidentDescription")
	private String incidentDescription;

	@Column(name = "incidentStateID")
	private String incidentStateID;

	@Column(name = "endUserComments")
	private String endUserComments;

	@Column(name = "stageComments")
	private String stageComments;
	
	@Column(name = "incidentPandingDays", columnDefinition = "integer default 0", nullable = false)
	private int incidentPandingDays=0;
	
	@CreatedBy
	@Column(name="createdBy")
	private String createdBy;

	@JsonIgnore
	@LastModifiedBy
	private String lastModifiedBy;
	
	@Column(name="createdDate")
	private Date createdDate;

	@JsonIgnore
	@LastModifiedDate
	private Date lastModifiedDate=new Date();
	
	@Column(name = "SLADuration")
	private String SLADuration;
	
	@Column(name = "IncidentCloseDuration")
	private String IncidentCloseDuration;
	
	@Column(name = "SLAMetORMissed")
	private Integer SLAMetORMissed;
	
	@Column(name = "CallCategory")
	private String CallCategory;
	
	@Column(name = "ResubmitDate")
	private Date ResubmitDate;
		
	@Column(name = "expectedEndDate")
	private String expectedEndDate;
	
	@Column(name = "infoRequiredFromUser")
	private String infoRequiredFromUser;
	
	@ManyToOne
	@JoinColumn(name = "assignedTo")
	private MstResourcePool assignedTo;
	
	@Column(name = "IncidentFor")
	private String IncidentFor;
	
	@ManyToOne
	@JoinColumn(name = "createuser")
	private MstResourcePool createuser;
	
	
	public MstResourcePool getCreateuser() {
		return createuser;
	}

	public void setCreateuser(MstResourcePool createuser) {
		this.createuser = createuser;
	}

	public Long getAutoIncidentId() {
		return autoIncidentId;
	}

	public void setAutoIncidentId(Long autoIncidentId) {
		this.autoIncidentId = autoIncidentId;
	}

	public String getIncidentId() {
		return IncidentId;
	}

	public void setIncidentId(String incidentId) {
		IncidentId = incidentId;
	}

	public MstApplication getTaiApplicationId() {
		return taiApplicationId;
	}

	public void setTaiApplicationId(MstApplication taiApplicationId) {
		this.taiApplicationId = taiApplicationId;
	}

	public MstIncidentState getTaiIncidentStateId() {
		return taiIncidentStateId;
	}

	public void setTaiIncidentStateId(MstIncidentState taiIncidentStateId) {
		this.taiIncidentStateId = taiIncidentStateId;
	}

	public MstPriority getTaiPriorityId() {
		return taiPriorityId;
	}

	public void setTaiPriorityId(MstPriority taiPriorityId) {
		this.taiPriorityId = taiPriorityId;
	}

	
	public MstIncidentType getTaiIncidentTypeId() {
		return taiIncidentTypeId;
	}

	public void setTaiIncidentTypeId(MstIncidentType taiIncidentTypeId) {
		this.taiIncidentTypeId = taiIncidentTypeId;
	}

	public MstIncidentSubType getTaiIncidentSubTypeId() {
		return taiIncidentSubTypeId;
	}

	public void setTaiIncidentSubTypeId(MstIncidentSubType taiIncidentSubTypeId) {
		this.taiIncidentSubTypeId = taiIncidentSubTypeId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getIncidentDescription() {
		return incidentDescription;
	}

	public void setIncidentDescription(String incidentDescription) {
		this.incidentDescription = incidentDescription;
	}

	public String getIncidentStateID() {
		return incidentStateID;
	}

	public void setIncidentStateID(String incidentStateID) {
		this.incidentStateID = incidentStateID;
	}

	public String getEndUserComments() {
		return endUserComments;
	}

	public void setEndUserComments(String endUserComments) {
		this.endUserComments = endUserComments;
	}

	public String getStageComments() {
		return stageComments;
	}

	public void setStageComments(String stageComments) {
		this.stageComments = stageComments;
	}

	public int getIncidentPandingDays() {
		return incidentPandingDays;
	}

	public void setIncidentPandingDays(int incidentPandingDays) {
		this.incidentPandingDays = incidentPandingDays;
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

	public String getSLADuration() {
		return SLADuration;
	}

	public void setSLADuration(String sLADuration) {
		SLADuration = sLADuration;
	}

	public String getIncidentCloseDuration() {
		return IncidentCloseDuration;
	}

	public void setIncidentCloseDuration(String incidentCloseDuration) {
		IncidentCloseDuration = incidentCloseDuration;
	}

	public Integer getSLAMetORMissed() {
		return SLAMetORMissed;
	}

	public void setSLAMetORMissed(Integer sLAMetORMissed) {
		SLAMetORMissed = sLAMetORMissed;
	}

	public String getCallCategory() {
		return CallCategory;
	}

	public void setCallCategory(String callCategory) {
		CallCategory = callCategory;
	}

	public Date getResubmitDate() {
		return ResubmitDate;
	}

	public void setResubmitDate(Date resubmitDate) {
		ResubmitDate = resubmitDate;
	}

	public String getExpectedEndDate() {
		return expectedEndDate;
	}

	public void setExpectedEndDate(String expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}

	public String getInfoRequiredFromUser() {
		return infoRequiredFromUser;
	}

	public void setInfoRequiredFromUser(String infoRequiredFromUser) {
		this.infoRequiredFromUser = infoRequiredFromUser;
	}

	public MstResourcePool getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(MstResourcePool assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getIncidentFor() {
		return IncidentFor;
	}

	public void setIncidentFor(String incidentFor) {
		IncidentFor = incidentFor;
	}
	
	
}
