package com.CTS.Project.Models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mst_locstate")
public class LocState {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stateId")
	private long stateId;
	
	@OneToMany
	@JoinTable(name = "resourceZoneId")
	private List<MstResourceZone> mstresourceZoneId;
	
	@Column(name = "stateName")
	private String stateName;
	
	@Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean isActive = true;

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	

	public List<MstResourceZone> getMstresourceZoneId() {
		return mstresourceZoneId;
	}

	public void setMstresourceZoneId(List<MstResourceZone> mstresourceZoneId) {
		this.mstresourceZoneId = mstresourceZoneId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


}
