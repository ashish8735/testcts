package com.CTS.Project.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_resource_designation")
public class MstResourceDesignation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "resourceDesignationId")
	private Long resourceDesignationId;

	@Column(name = "resourceDesignationName")
	private String resourceDesignationName;

	@Column(name = "description")
	private String description;

	@Column(name = "isActive", columnDefinition = "binary(1) default true", nullable = false)
	private Boolean isActive = true;

	public Long getResourceDesignationId() {
		return resourceDesignationId;
	}

	public void setResourceDesignationId(Long resourceDesignationId) {
		this.resourceDesignationId = resourceDesignationId;
	}

	public String getResourceDesignationName() {
		return resourceDesignationName;
	}

	public void setResourceDesignationName(String resourceDesignationName) {
		this.resourceDesignationName = resourceDesignationName;
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

	@Override
	public String toString() {
		return "ResourceDesignation [resourceDesignationId=" + resourceDesignationId + ", resourceDesignationName="
				+ resourceDesignationName + ", description=" + description + ", isActive=" + isActive + "]";
	}

}
