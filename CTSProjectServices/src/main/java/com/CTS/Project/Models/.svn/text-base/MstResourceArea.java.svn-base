package com.CTS.Project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_resource_area")
public class MstResourceArea {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "resourceAreaId")
   private  Long  resourceAreaId;
	
	 @Column(name = "resourceAreaName")
	   private  String  resourceAreaName;
	 
	 @Column(name = "resourceAreaDescription")
	   private  Long  resourceAreaDescription;
	 
	 @Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	    private Boolean isActive = true;

	public Long getResourceAreaId() {
		return resourceAreaId;
	}

	public void setResourceAreaId(Long resourceAreaId) {
		this.resourceAreaId = resourceAreaId;
	}

	public String getResourceAreaName() {
		return resourceAreaName;
	}

	public void setResourceAreaName(String resourceAreaName) {
		this.resourceAreaName = resourceAreaName;
	}

	public Long getResourceAreaDescription() {
		return resourceAreaDescription;
	}

	public void setResourceAreaDescription(Long resourceAreaDescription) {
		this.resourceAreaDescription = resourceAreaDescription;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "ResourceArea [resourceAreaId=" + resourceAreaId + ", resourceAreaName=" + resourceAreaName
				+ ", resourceAreaDescription=" + resourceAreaDescription + ", isActive=" + isActive + "]";
	}

	
	
}
