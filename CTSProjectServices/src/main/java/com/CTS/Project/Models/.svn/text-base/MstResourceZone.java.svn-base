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

import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "mst_resource_zone")
public class MstResourceZone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "resourceZoneId")
	private Long resourceZoneId;

	@OneToMany
	@JoinTable(name = "zoneStateId")
	private List<MstState> zoneStateId;

	@Column(name = "resourceZoneName")
	private String resourceZoneName;

	@Column(name = "resourceZoneDescription")
	private String resourceZoneDescription;

	@Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean isActive = true;
	
	@Transient
	Long count;
	
	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getResourceZoneId() {
		return resourceZoneId;
	}

	public void setResourceZoneId(Long resourceZoneId) {
		this.resourceZoneId = resourceZoneId;
	}

	public String getResourceZoneName() {
		return resourceZoneName;
	}

	public void setResourceZoneName(String resourceZoneName) {
		this.resourceZoneName = resourceZoneName;
	}

	public List<MstState> getZoneStateId() {
		return zoneStateId;
	}

	public void setZoneStateId(List<MstState> zoneStateId) {
		this.zoneStateId = zoneStateId;
	}

	public String getResourceZoneDescription() {
		return resourceZoneDescription;
	}

	public void setResourceZoneDescription(String resourceZoneDescription) {
		this.resourceZoneDescription = resourceZoneDescription;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "MstResourceZone [resourceZoneId=" + resourceZoneId + ", zoneStateId=" + zoneStateId
				+ ", resourceZoneName=" + resourceZoneName + ", resourceZoneDescription=" + resourceZoneDescription
				+ ", isActive=" + isActive + "]";
	}

	
}
