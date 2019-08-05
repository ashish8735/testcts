package com.CTS.Project.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mst_state")
public class MstState {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stateId")
	private long stateId;
	
	@OneToMany
	@JoinTable(name = "stateAreaId")
	private List<MstResourceArea> stateAreaId;

	public List<MstResourceArea> getStateAreaId() {
		return stateAreaId;
	}

	public void setStateAreaId(List<MstResourceArea> stateAreaId) {
		this.stateAreaId = stateAreaId;
	}

	@Column(name = "stateName")
	private String stateName;

	@Column(name = "abbreviation")
	private String abbreviation;

	@Column(name = "createdBy")
	private String createdBy;

	@JsonIgnore
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private Date createdOn = new Date();

	@Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean isActive = true;

	
	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "MstState [stateId=" + stateId + ", stateAreaId=" + stateAreaId + ", stateName=" + stateName
				+ ", abbreviation=" + abbreviation + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", isActive=" + isActive + "]";
	}

	
}
